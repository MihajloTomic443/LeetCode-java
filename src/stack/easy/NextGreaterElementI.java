package stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * LeetCode 496 - Next Greater Element I
 *
 * Difficulty: Easy
 * Topic: Stack, HashMap, Monotonic Stack
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 *
 * Idea:
 * Traverse nums2 while maintaining a monotonic decreasing stack.
 * Whenever the current element is greater than the top of the stack,
 * it is the next greater element for the stack's top, so store the
 * mapping in a HashMap. Finally, build the answer for nums1 using the map.
 *
 * Learned:
 * - A monotonic decreasing stack keeps unresolved elements.
 * - Every element is pushed and popped at most once, giving O(n) complexity.
 * - HashMap can store preprocessed answers for fast lookup.
 *
 * Solved: 2026-07-18
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()) {
                if (nums2[i] > stack.peek()) {
                    map.put(stack.pop(), nums2[i]);
                } else {
                    break;
                }
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}