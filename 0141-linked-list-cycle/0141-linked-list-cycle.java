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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode fake = new ListNode(-1, head);
        ListNode pt = head;
        while (pt != null) {
            if (!set.contains(pt)) {
                set.add(pt);
                pt = pt.next;
            } else {
                return true;
            }
        }
        return false;
    }
}