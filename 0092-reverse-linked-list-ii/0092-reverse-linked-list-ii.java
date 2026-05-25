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
        ListNode dummy = new ListNode(-1, head);
        ListNode p0 = dummy; // p0最终指向的应该是left左边的相邻节点
        int l = left - 1;
        while (l > 0) {
            p0 = p0.next;
            l--;
        }
        ListNode prev = p0;
        ListNode curr = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        p0.next.next = curr;
        p0.next = prev;
        return dummy.next;
    }
}