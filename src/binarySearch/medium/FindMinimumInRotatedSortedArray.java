package binarySearch.medium;

/*
LeetCode #153 - Find Minimum in Rotated Sorted Array

Difficulty: Medium
Topic: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
Compare the middle element with the right boundary.
If nums[mid] > nums[right], the minimum must be in the right half.
Otherwise, the minimum is at mid or in the left half.
Continue until both pointers meet.

Learned:
- Binary Search can locate the minimum without explicitly finding the rotation point.
- Sometimes the answer itself must remain in the search interval.
- When using right = mid, use while(left < right).
- The remaining element after convergence is the minimum.

Solved: 2026-07-06
*/

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}