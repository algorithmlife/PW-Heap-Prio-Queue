import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class KthSmallestArraySum {

    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.sum, b.sum));
        Set<String> visited = new HashSet<>();

        int[] initialIndices = new int[m];
        int initialSum = 0;
        for (int i = 0; i < m; i++) {
            initialSum += mat[i][0];
        }
        minHeap.add(new Element(initialSum, initialIndices));
        visited.add(Arrays.toString(initialIndices));

        while (k > 0) {
            Element current = minHeap.poll();
            k--;
            
            if (k == 0) {
                return current.sum;
            }
            
            for (int i = 0; i < m; i++) {
                if (current.indices[i] + 1 < n) {
                    int[] newIndices = Arrays.copyOf(current.indices, m);
                    newIndices[i]++;
                    
                    if (!visited.contains(Arrays.toString(newIndices))) {
                        int newSum = current.sum - mat[i][current.indices[i]] + mat[i][newIndices[i]];
                        minHeap.add(new Element(newSum, newIndices));
                        visited.add(Arrays.toString(newIndices));
                    }
                }
            }
        }
        
        return -1;
    }
    
    private static class Element {
        int sum;
        int[] indices;

        Element(int sum, int[] indices) {
            this.sum = sum;
            this.indices = indices;
        }
    }

    public static void main(String[] args) {
        KthSmallestArraySum solution = new KthSmallestArraySum();


        int[][] mat1 = {{1, 3, 11}, {2, 4, 6}};
        int k1 = 5;
        System.out.println("K-th smallest sum for mat1: " + solution.kthSmallest(mat1, k1)); 

        int[][] mat2 = {{1, 3, 11}, {2, 4, 6}};
        int k2 = 9;
        System.out.println("K-th smallest sum for mat2: " + solution.kthSmallest(mat2, k2)); 

        int[][] mat3 = {{1, 10, 10}, {1, 4, 5}, {2, 3, 6}};
        int k3 = 7;
        System.out.println("K-th smallest sum for mat3: " + solution.kthSmallest(mat3, k3)); 
    }
}
