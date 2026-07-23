package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 503 - Next Greater Element II
 *
 * Difficulty: Medium
 * Topic: Stack, Monotonic Stack
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Idea:
 * We traverse the array twice to simulate a circular array.
 * The stack stores indices of elements whose next greater element
 * has not yet been found. Whenever the current element is greater
 * than the element at the top index of the stack, we update the answer.
 * Indices are pushed only during the first traversal to avoid duplicates.
 *
 * Learned:
 * - Circular arrays can be simulated by iterating 2 * n times.
 * - Use i % n to wrap around the array.
 * - Store indices instead of values when answers must be written
 *   into a result array.
 * - Each index is pushed and popped at most once.
 *
 * Solved: 2026-07-23
 */
public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                answer[stack.pop()] = nums[index];
            }

            if (i < n) {
                stack.push(index);
            }
        }

        return answer;
    }
}