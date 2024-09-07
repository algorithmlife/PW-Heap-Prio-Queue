import java.util.PriorityQueue;

public class KthLargestElement {
    

    public static int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);


        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }


        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) 
    {

        int[] arr1 = {1, 2, 3, 5, 2, 6, 9};
        int k1 = 3;
        System.out.println("The " + k1 + "rd largest element is " + findKthLargest(arr1, k1));

        int[] arr2 = {1, 7, 8, 5, 2, 6, 9};
        int k2 = 6;
        System.out.println("The " + k2 + "th largest element is " + findKthLargest(arr2, k2));
    }
}
