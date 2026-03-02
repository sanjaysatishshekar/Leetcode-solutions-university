class Node {
    int key, val;
    Node prev, next;
    Node(int k, int v) {
        key = k;
        val = v;
    }
}

class LRUCache {
    Node head, tail;
    Map<Integer, Node> table;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);    
        tail = new Node(-1, -1);    
        head.next = tail;
        tail.prev = head;
        table = new HashMap<>();
    }

    private void add(Node node) {
        Node previousNode = tail.prev;
        previousNode.next = node;
        node.prev = previousNode;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if (!table.containsKey(key)) {
            return -1;
        }
        Node node = table.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (table.containsKey(key)) {
            Node nodeToRemove = table.get(key);
            remove(nodeToRemove);
        }
        Node newNode = new Node(key, value);
        add(newNode);
        table.put(key, newNode);
        if (table.size() > this.capacity) {
            Node nodeToDelete = head.next;
            remove(nodeToDelete);
            table.remove(nodeToDelete.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */