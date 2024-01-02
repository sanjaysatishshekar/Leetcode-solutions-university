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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        int k = lists.length;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) pq.add(lists[i]); 
        }
        while (!pq.isEmpty()) {
            ListNode a = pq.poll();
            temp.next = a;
            temp = temp.next;
            if (a.next != null) {
                pq.add(a.next);
            }
        }
        return newHead.next;
    }
}