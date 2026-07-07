package binarySearch;

/*
LeetCode #704 - Binary Search

Difficulty: Easy
Topic: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
Maintain two pointers representing the current search interval.
Find the middle element.
If the middle element is the target, return its index.
Otherwise, discard half of the search space based on comparison.
Repeat until the interval becomes empty.

Learned:
- Binary Search works only on sorted arrays.
- Each iteration removes half of the remaining search space.
- Use left <= right because a single remaining element is still a valid candidate.
- Update boundaries with mid + 1 or mid - 1 to avoid infinite loops.

Solved: 2026-07-06
*/
public class BinarySearch {

    public int search(int[] nums, int target) {
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

        return -1;
    }
}