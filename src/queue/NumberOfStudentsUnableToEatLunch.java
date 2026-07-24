package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
LeetCode #1700 - Number of Students Unable to Eat Lunch
Difficulty: Easy
Topic: Queue, Stack, Simulation

Time Complexity: O(n)
Space Complexity: O(n)

Idea:
Simulate the lunch process using a Queue for students and a Stack for sandwiches.
If the first student prefers the top sandwich, remove both.
Otherwise, move the student to the back of the queue.
Use a counter to count consecutive students that reject the current sandwich.
If every remaining student rejects the current sandwich, no more students can eat.

Learned:
- Practiced combining Queue and Stack in one simulation.
- Learned how to rotate a Queue by moving the front element to the back.
- Learned how to detect when a simulation starts repeating using a counter.
- Reinforced the difference between FIFO (Queue) and LIFO (Stack).

Solved: 2026-07-24
*/
public class NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = sandwiches.length - 1; i != -1; i--){
            stack.push(sandwiches[i]);
        }

        for(int i = 0; i < students.length; i++){
            queue.offer(students[i]);
        }

        int cnt = 0;

        while(cnt != queue.size()){

            if(stack.peek() == queue.peek()){
                stack.pop();
                queue.poll();
                cnt = 0;
            } else {
                queue.offer(queue.poll());
                cnt++;
            }

            if(queue.isEmpty()) return 0;
        }

        return stack.size();
    }
}