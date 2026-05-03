/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondPointer = slow.next;
        ListNode prev = null;
        slow.next = null;

        while(secondPointer != null) {
            ListNode temp = secondPointer.next;
            secondPointer.next = prev;
            prev = secondPointer;
            secondPointer = temp;
        } 

        ListNode firstPointer = head;
        secondPointer = prev;

        while(secondPointer != null) {
            ListNode temp1 = firstPointer.next;
            ListNode temp2 = secondPointer.next;

            firstPointer.next = secondPointer;
            secondPointer.next = temp1;

            firstPointer = temp1;
            secondPointer = temp2;
        }
    }
}
