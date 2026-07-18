package stack.medium;

import java.util.Stack;

/*
LeetCode #150 - Evaluate Reverse Polish Notation

Difficulty: Medium
Topic: Stack

Time Complexity: O(n)
Space Complexity: O(n)

Idea:
Traverse the array of tokens.
- If the token is a number, push it onto the stack.
- If the token is an operator, pop the last two numbers,
  perform the operation, and push the result back.
- The remaining value in the stack is the final answer.

Learned:
- Reverse Polish Notation (RPN) is naturally solved using a stack.
- The order of popped elements is important for subtraction and division.
- Integer.parseInt() converts a String into an integer.
- A stack allows expression evaluation in a single pass.

Solved: 2026-07-17
*/

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else if (tokens[i].equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if (tokens[i].equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second + first);
            } else if (tokens[i].equals("*")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second * first);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}