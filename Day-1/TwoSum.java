 // Day 1 - Problem 1
// Practicing basics of arrays and loops {
    
// Problem: Two Sum
// Platform: LeetCode
// Approach: Brute Force (O(n^2))

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] {}; // no solution case
    }
}
