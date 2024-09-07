import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minCost(int[] ropes) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int totalCost = 0;

        while (minHeap.size() > 1) {

            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;

            minHeap.offer(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {

        int[] ropes = {5, 4, 2, 8};
        int result = minCost(ropes);
        System.out.println("The minimum cost to connect all ropes is: " + result);
    }
}
