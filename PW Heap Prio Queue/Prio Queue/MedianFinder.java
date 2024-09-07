import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap; 
    private PriorityQueue<Integer> minHeap; 

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>(); 
    }

    public void addNum(int num) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(5);
        System.out.println(mf.findMedian());  
        mf.addNum(15);
        System.out.println(mf.findMedian());  
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian()); 
    }
}
