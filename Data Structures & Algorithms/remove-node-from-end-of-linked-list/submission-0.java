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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ) {
            return head;
        }
        int length = 0;
        ListNode cur = head;
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        int nodeToReach = length - n;
        if(nodeToReach == 0) {
            return head.next;
        }

        cur = head;
        for(int i=0;i<length - 1;i++) {
            if((i + 1) == nodeToReach) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
