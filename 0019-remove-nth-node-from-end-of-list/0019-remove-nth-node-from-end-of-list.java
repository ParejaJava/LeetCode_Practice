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
        ListNode fake = new ListNode (-1, head);
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode arrow = fake;
        while (arrow != null) {
            stack.push(arrow);
            arrow = arrow.next;
        }
        for (int i = 1; i <= n; i++) {
            stack.pop();
        }
        arrow = stack.peek();
        arrow.next = arrow.next.next;
        return fake.next;
    }
}