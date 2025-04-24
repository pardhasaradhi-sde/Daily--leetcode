import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Frequency map to store the count of each number
        HashMap<Integer, Integer> m1 = new HashMap<>();
        for (int num : nums) {
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }

        // Priority queue to store the elements in the order of frequency
        PriorityQueue<Map.Entry<Integer, Integer>> p1 = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        // Add all entries to the priority queue
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            p1.offer(entry);
        }

        // Result array to store the top k frequent elements
        int num[] = new int[k];
        int i = 0;

        // Remove the least frequent elements from the queue to get the top k
        while (p1.size() > k) {
            p1.poll();
        }

        // Add the remaining elements (top k frequent elements) to the result array
        while (!p1.isEmpty()) {
            num[i] = p1.poll().getKey();
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(solution.topKFrequent(nums, k)));
        // Output: [1, 2]
    }
}
