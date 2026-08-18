package linkedList.medium;

/*
 * LeetCode 61 - Rotate List
 *
 * Difficulty: Medium
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 *
 * Idea:
 * Traverse the linked list once to find its length and last node.
 * Reduce k using the list length.
 * Find the new last node at the position where the list should be cut.
 * Connect the old last node to the original head.
 * Move the head to the new first node and break the old connection.
 *
 * Learned:
 * - Learned how to rotate a linked list by changing its connections.
 * - Practiced finding the length and last node in one traversal.
 * - Learned how to use k % length to avoid unnecessary rotations.
 * - Practiced reconnecting and cutting a linked list at a specific position.
 *
 * Solved: 2026-08-18
 */

import linkedList.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        ListNode current = head;
        ListNode last = null;
        int x = 0;

        while (current != null) {
            x++;
            last = current;
            current = current.next;
        }

        current = head;
        k = k % x;
        int cut = x - k;

        while (cut != 0) {
            cut--;

            if (cut == 0) {
                break;
            }

            current = current.next;
        }

        last.next = head;
        head = current.next;
        current.next = null;

        return head;
    }
}