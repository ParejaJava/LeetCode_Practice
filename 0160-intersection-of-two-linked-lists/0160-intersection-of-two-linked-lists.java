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
        Set<ListNode> set = new HashSet<>();
        while (fA != null) {
            set.add(fA);
            fA = fA.next;
        }
        while(fB != null) {
            if(set.contains(fB)) {
                return fB;
            }
            fB = fB.next;
        }
        return null;
    }
}