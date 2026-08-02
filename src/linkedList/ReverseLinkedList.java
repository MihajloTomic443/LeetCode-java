package linkedList;

/*
 * LeetCode 206 - Reverse Linked List
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Idea:
 * Traverse the linked list once using three pointers.
 * Store the next node before changing the current node's next pointer.
 * Reverse the link, move the previous pointer forward,
 * and continue until the end of the list.
 * Return the previous pointer as the new head.
 *
 * Learned:
 * - Learned the basic pointer reversal pattern.
 * - Always save the next node before changing links.
 * - The previous pointer becomes the new head after the traversal.
 * - Linked List problems are solved by manipulating pointers rather than values.
 *
 * Solved: 2026-08-02
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}