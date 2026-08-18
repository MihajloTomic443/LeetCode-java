package linkedList.medium;

/*
 * LeetCode 82 - Remove Duplicates from Sorted List II
 *
 * Difficulty: Medium
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 *
 * Idea:
 * Traverse the sorted linked list and detect groups of duplicate values.
 * When a duplicate group is found, skip the entire group by connecting
 * the previous node directly to the first node after the duplicate group.
 * A dummy node is used to handle duplicate groups at the beginning of the list.
 *
 * Learned:
 * - Learned how to remove an entire group of duplicate nodes.
 * - Practiced using a dummy node to handle duplicates at the head of the list.
 * - Practiced keeping a previous pointer to reconnect the list after removing nodes.
 * - Learned how to detect and skip consecutive duplicate values in a sorted list.
 *
 * Solved: 2026-08-18
 */

import linkedList.ListNode;

public class RemoveDuplicatesFromSortedListII {

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode current = head;
            ListNode next = current.next;
            ListNode dummy = new ListNode (-1);
            ListNode previous = dummy;
            dummy.next = head;
            while(current.next != null){
                if(current.val == next.val){
                    while(current.next != null && current.val == current.next.val){
                        current = current.next;
                    }
                    next = current.next;
                    current = previous;
                    previous.next = next;
                } else {
                    previous = current;
                    current = next;
                    next = current.next;
                }
            }
            return dummy.next;
        }

}