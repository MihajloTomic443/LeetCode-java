package strings;

/*
LeetCode #125 - Valid Palindrome

Difficulty: Easy
Topic: Strings, Two Pointers

Time Complexity: O(n)
Space Complexity: O(1)

Idea:
Use two pointers starting from both ends of the string.
Skip all non-alphanumeric characters.
Compare the remaining characters case-insensitively.
If any pair differs, return false.
If all pairs match, return true.

Learned:
- Two pointers can traverse a string from both ends efficiently.
- Character.isLetterOrDigit() helps ignore special characters.
- Character comparison should be case-insensitive.
- Extra memory is not needed for this problem.

Solved: 2026-07-06
*/
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (!Character.isLetterOrDigit(s.charAt(left))
                    && Character.isLetterOrDigit(s.charAt(right))) {
                left++;

            } else if (Character.isLetterOrDigit(s.charAt(left))
                    && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;

            } else if (!Character.isLetterOrDigit(s.charAt(left))
                    && !Character.isLetterOrDigit(s.charAt(right))) {
                left++;
                right--;

            } else if (s.charAt(left) != s.charAt(right)) {
                return false;

            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}
