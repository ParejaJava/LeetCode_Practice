/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fake = new ListNode(-1, head);
        Set<ListNode> set = new HashSet<>();
        ListNode p = fake;
        while (p != null) {
            if(set.contains(p)) {
                return p;
            }
            else {
                set.add(p);
            }
            p = p.next;
        }
        return null;
    }
}