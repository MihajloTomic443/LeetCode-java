package stack.easy;

import java.util.Stack;

/*
LeetCode #1047 - Remove All Adjacent Duplicates In String

Difficulty: Easy
Topic: Stack

Time Complexity: O(n)
Space Complexity: O(n)

Idea:
Traverse the string from left to right.
If the stack is empty or the current character is different from
the top of the stack, push it.
Otherwise, remove the duplicate by popping the top element.
Finally, build the answer by popping all remaining characters
and reverse the result because Stack is LIFO.

Learned:
- Stack can represent the current valid characters.
- Adjacent duplicates cancel each other.
- StringBuilder is useful for efficiently building strings.
- reverse() restores the original order after popping from the stack.

Solved: 2026-07-06
*/

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        if (s.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}