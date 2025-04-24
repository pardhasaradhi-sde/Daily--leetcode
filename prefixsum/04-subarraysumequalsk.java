# it also uses siding window in addition of prefixsum
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixsum = new HashMap<>();
        prefixsum.put(0, 1);
        int currentsum = 0;
        int count = 0;
        for (int num : nums) {
            currentsum += num;
            if (prefixsum.containsKey(currentsum - k)) {
                count += prefixsum.get(currentsum - k);
            }
            prefixsum.put(currentsum, prefixsum.getOrDefault(currentsum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("The number of subarrays with sum " + k + " is: " + sol.subarraySum(nums, k));
    }
}
