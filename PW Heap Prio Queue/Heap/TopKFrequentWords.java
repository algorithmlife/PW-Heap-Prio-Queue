import java.util.*;

public class TopKFrequentWords {


    public static List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = frequencyMap.get(w1) - frequencyMap.get(w2);
            if (freqCompare == 0) {
                return w2.compareTo(w1);
            }
            return freqCompare; 
        });

        for (String word : frequencyMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();  
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        
        return result;
    }

    public static void main(String[] args) {

        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println("Top " + k1 + " frequent words: " + topKFrequent(words1, k1));

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println("Top " + k2 + " frequent words: " + topKFrequent(words2, k2));
    }
}
