// Day 1 - Problem 2
// Problem: Find Numbers with Even Number of Digits
// Platform: LeetCode
// Approach: Convert number to string and check length

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i : nums) {
            if (String.valueOf(i).length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}