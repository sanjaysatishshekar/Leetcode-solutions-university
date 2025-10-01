class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> dict;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        dict = new HashMap<>();
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
        if (!dict.containsKey(key)) {
            return -1;
        }
        Node node = dict.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (dict.containsKey(key)) {
            Node oldNode = dict.get(key);
            remove(oldNode);
        }
        Node newNode = new Node(key, value);
        dict.put(key, newNode);
        add(newNode);
        if (dict.size() > capacity) {
            Node nodeToDel = head.next; 
            remove(nodeToDel); 
            dict.remove(nodeToDel.key); 
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */