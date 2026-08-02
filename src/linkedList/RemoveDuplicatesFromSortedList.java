package linkedList;

/*
 * LeetCode 83 - Remove Duplicates from Sorted List
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Idea:
 * Traverse the sorted linked list once.
 * If the current node and the next node have the same value,
 * remove the duplicate by skipping the next node.
 * Otherwise, move to the next node.
 *
 * Learned:
 * - Learned how to remove nodes by changing next pointers.
 * - Understood the difference between moving a pointer and modifying the linked list.
 * - Practiced traversing a linked list while deleting duplicate nodes.
 *
 * Solved: 2026-08-02
 */

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}