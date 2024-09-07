import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

public class RearrangeString {

    public String reorganizeString(String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        maxHeap.addAll(frequencyMap.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prevEntry = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            result.append(currentEntry.getKey());

            currentEntry.setValue(currentEntry.getValue() - 1);

            if (prevEntry != null && prevEntry.getValue() > 0) {
                maxHeap.offer(prevEntry);
            }

            prevEntry = currentEntry;
        }

        if (result.length() == s.length()) {
            return result.toString();
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        RearrangeString rearrangeString = new RearrangeString();
        

        String s1 = "aab";
        System.out.println("Rearranged string for 'aab': " + rearrangeString.reorganizeString(s1));

        String s2 = "aaab";
        System.out.println("Rearranged string for 'aaab': " + rearrangeString.reorganizeString(s2));
    }
}
