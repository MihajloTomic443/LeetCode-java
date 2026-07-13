package stack;

import java.util.Stack;

/*
LeetCode #682 - Baseball Game

Difficulty: Easy
Topic: Stack

Time Complexity: O(n)
Space Complexity: O(n)

Idea:
Traverse the operations array.
- If the operation is a number, push it onto the stack.
- "C": remove the previous valid score.
- "D": duplicate the previous valid score.
- "+": sum the last two valid scores and push the result.
Finally, pop all elements from the stack and compute the total score.

Learned:
- peek() is useful when the value should be read but not removed.
- pop() should only be used when the value is no longer needed.
- Different stack operations may require different stack methods.
- Design each operation independently instead of forcing one approach.

Solved: 2026-07-06
*/

public class BaseballGame {

    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {

            if (!operations[i].equals("D")
                    && !operations[i].equals("C")
                    && !operations[i].equals("+")) {

                stack.push(Integer.parseInt(operations[i]));

            } else {

                if (operations[i].equals("+") && stack.size() > 1) {

                    int first = stack.pop();
                    int sum = first + stack.peek();

                    stack.push(first);
                    stack.push(sum);

                } else if (operations[i].equals("C")) {

                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                } else if (operations[i].equals("D") && !stack.isEmpty()) {

                    stack.push(stack.peek() * 2);

                }
            }
        }

        int total = 0;

        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}