package math;
/*
LeetCode #9 - Palindrome Number
Difficulty: Easy
Topic: Math

Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
Reverse the number using modulo (%) and integer division (/).
Compare the reversed number with the original number.

Learned:
- Reverse an integer without converting it to String.
- %10 extracts the last digit.
- /10 removes the last digit.

Solved: 2026-07-06
*/
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int reversed = 0;
        int original = x;
        if (x < 0) return false;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == original;
    }
}
