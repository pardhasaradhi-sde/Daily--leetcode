import java.util.Arrays;

public class Solution {
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        mergeSort(nums, left, right);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftar = new int[n1];
        int[] rightar = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftar[i] = nums[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightar[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftar[i] <= rightar[j]) {
                nums[k++] = leftar[i++];
            } else {
                nums[k++] = rightar[j++];
            }
        }

        while (i < n1) {
            nums[k++] = leftar[i++];
        }

        while (j < n2) {
            nums[k++] = rightar[j++];
        }
    }

    // Main method to test your sort
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] input = {5, 2, 3, 1, 4};
        System.out.println("Original Array: " + Arrays.toString(input));

        int[] sorted = sol.sortArray(input);
        System.out.println("Sorted Array:   " + Arrays.toString(sorted));
    }
}
