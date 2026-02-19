/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fA = new ListNode(-1, headA);
        ListNode fB = new ListNode(-1, headB);
        ListNode a = fA;
        ListNode b = fB;
        while(a != b) {
            if(a == null) {
                a = fB;
            }
            if(b == null) {
                b = fA;
            }
            a = a.next;
            b = b.next;
        }
        return a;
    }
}