package linkedList.medium;



/*
 * LeetCode 86 - Partition List
 *
 * Difficulty: Medium
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Idea:
 * Traverse the linked list once.
 * Build two separate lists:
 * one containing nodes with values less than x,
 * and one containing nodes with values greater than or equal to x.
 * Connect the two lists at the end while preserving
 * the original relative order of the nodes.
 *
 * Learned:
 * - Learned how to partition a linked list into two lists.
 * - Practiced building multiple linked lists simultaneously.
 * - Understood how dummy nodes simplify list construction.
 * - Learned to reconnect multiple linked lists safely.
 *
 * Solved: 2026-08-06
 */

import linkedList.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode current = head;

        ListNode dummyLess = new ListNode(-1);
        ListNode dummyGreather = new ListNode(-1);

        ListNode currentLess = dummyLess;
        ListNode currentGreather = dummyGreather;

        while (current != null) {

            ListNode next = current.next;

            if (current.val < x) {
                currentLess.next = current;
                currentLess = currentLess.next;
                current = next;
            } else {
                currentGreather.next = current;
                currentGreather = currentGreather.next;
                current = next;
            }
        }

        currentGreather.next = null;
        currentLess.next = dummyGreather.next;

        return dummyLess.next;
    }
}