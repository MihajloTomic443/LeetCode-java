package stack.easy;

import java.util.Stack;

/*
LeetCode #20 - Valid Parentheses

Difficulty: Easy
Topic: Stack

Time Complexity: O(n)
Space Complexity: O(n)

Idea:
Traverse the string from left to right.
Push every opening bracket onto the stack.
When a closing bracket is encountered, check whether it matches
the opening bracket on the top of the stack.
If it matches, pop it.
Otherwise, return false immediately.
At the end, the stack must be empty.

Learned:
- Stack follows the Last In, First Out (LIFO) principle.
- Push opening brackets.
- Match closing brackets with the top of the stack.
- If a mismatch occurs or the stack is empty when a closing bracket appears,
  the string is invalid.
- The stack must be empty after processing all characters.

Solved: 2026-07-06
*/

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() && (c == ']' || c == ')' || c == '}')) {
                return false;
            }

            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
                continue;
            }

            if (!stack.isEmpty()
                    && ((c == ']' && stack.peek() == '[')
                    || (c == '}' && stack.peek() == '{')
                    || (c == ')' && stack.peek() == '('))) {

                stack.pop();

            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}