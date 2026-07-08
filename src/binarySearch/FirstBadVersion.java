package binarySearch;

/*
LeetCode #278 - First Bad Version

Difficulty: Easy
Topic: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
Use Binary Search to find the first bad version.
If the current version is bad, keep it in the search range because
it might be the first bad version.
Otherwise, search the right half.
When the pointers meet, they point to the first bad version.

Learned:
- Binary Search can be applied to monotonic boolean functions.
- Sometimes the middle element must remain in the search space.
- Use while(left < right) when searching for a boundary.
- Return the remaining pointer after the search converges.

Solved: 2026-07-06
*/

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int version) {
        int n = 4;
        return version == n;
    }
}