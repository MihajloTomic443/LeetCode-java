package stack.easy;

import java.util.Stack;

/*
LeetCode #844 - Backspace String Compare

Difficulty: Easy
Topic: Stack

Time Complexity: O(n + m)
Space Complexity: O(n + m)

Idea:
Process both strings independently using a stack.
For each string:
- Push regular characters onto the stack.
- If '#' appears, remove the previous character if possible.
After processing both strings, compare the resulting strings.

Learned:
- A helper method can simplify problems by processing one input independently.
- Stack can be used to simulate text editing operations.
- Always check if the stack is empty before calling pop().
- StringBuilder.reverse() can restore the original order after popping all elements from a stack.
- Decomposing a problem into smaller reusable functions often leads to cleaner code.

Solved: 2026-07-17
*/

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return stringCheck(s).equals(stringCheck(t));
    }

    private String stringCheck(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}