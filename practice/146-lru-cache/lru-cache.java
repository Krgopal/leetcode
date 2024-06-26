class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void add(ListNode node) {
        ListNode headStart = head.next;
        head.next = node;
        node.prev = head;
        node.next = headStart;
        headStart.prev = node;
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
        } 
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        add(node);
        if (map.size() > capacity) {
            ListNode nodeToBeDeleted = tail.prev;
            remove(nodeToBeDeleted);
            map.remove(nodeToBeDeleted.key);
        }
    }
}
class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */