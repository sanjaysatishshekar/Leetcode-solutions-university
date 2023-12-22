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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (list1 != null && list2 != null) {
            int x = list1 != null ? list1.val : -1;
            int y = list2 != null ? list2.val : -1;
            if (x > y) {
                temp.next = new ListNode(y);
                list2 = list2.next;
            }
            else {
                temp.next = new ListNode(x);
                list1 = list1.next;
            }
            temp = temp.next;
        }
        while (list1 != null) {
            temp.next = new ListNode(list1.val);
            temp = temp.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            temp = temp.next;
            list2 = list2.next;
        }
        return newHead.next;
    }
}