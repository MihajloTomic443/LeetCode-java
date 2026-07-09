package binarySearch;

/*
LeetCode #744 - Find Smallest Letter Greater Than Target

Difficulty: Easy
Topic: Binary Search

Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
Treat every character greater than the target as a valid candidate.
Use Binary Search to find the first character strictly greater than the target.
If no such character exists, return the first character in the array
because the search wraps around.

Learned:
- Binary Search can search for the first element satisfying a condition.
- The equality case belongs to the "go right" branch because we need a strictly greater value.
- Keep the candidate in the search range using right = mid.
- Handle the wrap-around case after the search.

Solved: 2026-07-06
*/

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == letters.length - 1 && letters[left] <= target) {
            return letters[0];
        }

        return letters[left];
    }
}