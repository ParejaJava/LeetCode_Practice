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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left-1; i++) {
            p0 = p0.next;
        }
        ListNode prev = null;
        ListNode curr = p0.next;
        ListNode nxt = null;
        for (int i = 0; i < right-left+1; i++) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        p0.next.next = curr;
        p0.next = prev;
        return dummy.next;
    }
}