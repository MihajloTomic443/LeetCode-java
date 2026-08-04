package linkedList;



/*
 * LeetCode 24 - Swap Nodes in Pairs
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Idea:
 * Use a dummy node before the head of the list.
 * Process the list in pairs.
 * Swap each adjacent pair by updating the next pointers.
 * Move to the next pair and repeat until fewer than two nodes remain.
 *
 * Learned:
 * - Practiced swapping adjacent nodes without changing node values.
 * - Learned how a dummy node simplifies pointer manipulation.
 * - Improved understanding of updating multiple next pointers safely.
 * - Practiced processing a linked list pair by pair.
 *
 * Solved: 2026-08-04
 */

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            ListNode nextPair = current.next.next.next;

            current.next = second;
            second.next = first;
            first.next = nextPair;

            current = first;
        }

        return dummy.next;
    }
}