package linkedList.easy;
/*
 * LeetCode 21 - Merge Two Sorted Lists
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Idea:
 * Traverse both sorted linked lists simultaneously.
 * Compare the current nodes and attach the smaller one
 * to the end of the merged list.
 * Use a dummy node to simplify handling the head of the result.
 * After one list is exhausted, attach the remaining part
 * of the other list.
 *
 * Learned:
 * - Learned how to merge two linked lists using pointer manipulation.
 * - Understood the purpose of a dummy node.
 * - Learned that attaching current.next to a list connects the entire remaining list.
 * - Practiced building a linked list using a moving current pointer.
 *
 * Solved: 2026-08-02
 */

import linkedList.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;

            } else {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        }

        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }

        return dummy.next;
    }
}