/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // System.out.println(prev.val);

        ListNode end = prev;
        ListNode start = head;
        ListNode temp2 = null;
        ListNode temp1 = null;
        while (start != null && end != null) {
            temp2 = end.next;
            temp1 = start.next;
            start.next = end;
            end.next = temp1;
            start = temp1;
            end = temp2;
        }
    }
}