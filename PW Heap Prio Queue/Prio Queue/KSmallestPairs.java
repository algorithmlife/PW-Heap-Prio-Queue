import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1])
        );


        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[] {nums1[i], nums2[0], 0}); 
        }


        while (k > 0 && !minHeap.isEmpty()) {
            int[] currentPair = minHeap.poll();
            result.add(Arrays.asList(currentPair[0], currentPair[1]));

            int indexInNums2 = currentPair[2];
            if (indexInNums2 + 1 < nums2.length) {

                minHeap.offer(new int[] {currentPair[0], nums2[indexInNums2 + 1], indexInNums2 + 1});
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        KSmallestPairs ksp = new KSmallestPairs();


        int[] nums1_1 = {1, 7, 11};
        int[] nums2_1 = {2, 4, 6};
        int k1 = 3;
        System.out.println(ksp.kSmallestPairs(nums1_1, nums2_1, k1));

        int[] nums1_2 = {1, 1, 2};
        int[] nums2_2 = {1, 2, 3};
        int k2 = 2;
        System.out.println(ksp.kSmallestPairs(nums1_2, nums2_2, k2));


        int[] nums1_3 = {1, 2};
        int[] nums2_3 = {3};
        int k3 = 3;
        System.out.println(ksp.kSmallestPairs(nums1_3, nums2_3, k3));
    }
}
