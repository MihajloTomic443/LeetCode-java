package binarySearch;

/*
LeetCode #34 - Find First and Last Position of Element in Sorted Array

Difficulty: Medium
Topic: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
Use two Binary Searches.
The first search finds the leftmost (first) occurrence of the target.
The second search finds the rightmost (last) occurrence.
Whenever the target is found, continue searching in the required direction
instead of stopping immediately.

Learned:
- Binary Search can search for boundaries instead of stopping at the first match.
- Continue searching left to find the first occurrence.
- Continue searching right to find the last occurrence.
- Two Binary Searches still have O(log n) time complexity.

Solved: 2026-07-06
*/

public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int first = -1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{first, last};
    }
}