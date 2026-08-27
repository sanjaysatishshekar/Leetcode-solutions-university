/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        Node copyList = head.next;
        Node copy = copyList;
        Node original = head;
        while(original != null){
            original.next = original.next.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyList;
    }
}