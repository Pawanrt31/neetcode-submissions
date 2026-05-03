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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode cur = head;
        int group = 0;
        while(cur != null && group < k) {
            cur = cur.next;
            group++;
        }
        if(group == k) {
            ListNode prev = reverseKGroup(cur, k);
            cur = head;
            while(group-- > 0) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            head = prev;
        }
        return head;
    }
}
