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
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        ListNode prev = null;
        cur = head;
        ListNode nxt = null;
        while (n >= k) {
            for (int i = 0; i < k; i++) {
                nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;
            }
            nxt = p0.next;
            p0.next.next = cur;
            p0.next = prev;
            p0 = nxt;
            n -= k;
        }
        return dummy.next;
    }
}