package arrays;

/*
LeetCode #88 - Merge Sorted Array

Difficulty: Easy
Topic: Arrays, Two Pointers

Time Complexity: O(m + n)
Space Complexity: O(1)

Idea:
Use three pointers starting from the end of both arrays.
Compare the largest remaining elements and place the larger one
at the end of nums1.
Continue until all elements from nums2 have been merged.

Learned:
- Working from the end avoids overwriting values in nums1.
- Multiple pointers can merge two sorted arrays in linear time.
- In-place merging eliminates the need for extra memory.

Solved: 2026-07-06
*/
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}