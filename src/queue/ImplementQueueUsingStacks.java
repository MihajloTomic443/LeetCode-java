package queue.easy;

import java.util.Stack;

/*
LeetCode #232 - Implement Queue using Stacks

Difficulty: Easy
Topic: Queue, Stack

Time Complexity:
- push()  -> O(1)
- pop()   -> O(n)
- peek()  -> O(n)
- empty() -> O(1)

Space Complexity: O(n)

Idea:
Use two stacks to simulate a queue.
The first stack stores all incoming elements.
The second stack is used for removing and peeking elements.
Transfer elements from the first stack to the second stack
only when the second stack becomes empty.

Learned:
- Two stacks can simulate the FIFO behavior of a queue.
- Keep incoming and outgoing elements in separate stacks.
- Transfer elements only when necessary.
- Delaying expensive operations leads to an amortized O(1) solution.

Solved: 2026-07-26
*/

public class ImplementQueueUsingStacks {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}