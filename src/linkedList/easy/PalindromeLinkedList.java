package linkedList.easy;



/*
 * LeetCode 234 - Palindrome Linked List
 *
 * Difficulty: Easy
 * Topic: Linked List
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Idea:
 * Find the middle of the linked list using fast and slow pointers.
 * Reverse the second half of the list.
 * Compare the first half with the reversed second half.
 * If all corresponding values are equal, the list is a palindrome.
 *
 * Learned:
 * - Learned the Fast & Slow Pointer pattern to find the middle of a linked list.
 * - Reused the Reverse Linked List pattern to reverse the second half.
 * - Practiced comparing two linked lists node by node.
 * - Combined multiple linked list patterns into one solution.
 *
 * Solved: 2026-08-04
 */

import linkedList.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        while (previous != null) {
            if (head.val != previous.val) {
                return false;
            }

            head = head.next;
            previous = previous.next;
        }

        return true;
    }
}