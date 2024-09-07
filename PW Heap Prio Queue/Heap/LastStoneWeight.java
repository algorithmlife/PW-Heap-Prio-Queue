import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {

            int stone1 = maxHeap.poll(); 
            int stone2 = maxHeap.poll(); 

            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {

        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Last remaining stone weight: " + lastStoneWeight(stones1)); 


        int[] stones2 = {1};
        System.out.println("Last remaining stone weight: " + lastStoneWeight(stones2));
    }
}
