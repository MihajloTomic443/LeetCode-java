package binarySearch;

/*
LeetCode #35 - Search Insert Position

Difficulty: Easy
Topic: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
Perform a standard binary search.
If the target is found, return its index.
Otherwise, when the search interval becomes empty,
the left pointer represents the correct insertion position.

Learned:
- Binary Search can be used even when the target is not present.
- When the search ends, left points to the insertion index.
- Always update boundaries with mid + 1 or mid - 1.
- Binary Search is useful for finding positions, not only exact values.

Solved: 2026-07-06
*/
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}