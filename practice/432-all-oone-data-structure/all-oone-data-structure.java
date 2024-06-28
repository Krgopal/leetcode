class AllOne {

    Map<String, Node> keysMap;
    Node head;
    Node tail;
    public AllOne() {
        this.keysMap = new HashMap<>();
        this.head = new Node(Integer.MIN_VALUE);
        this.tail = new Node(Integer.MAX_VALUE);
        this.head.next = tail;
        this.tail.prev = this.head;
    }
    
    public void inc(String key) {
        if (keysMap.containsKey(key)) {
            Node current = keysMap.get(key);
            current.keys.remove(key);
            Node next = current.next;
            if (next != tail && next.count == current.count +1) {
                next.keys.add(key);
            } else {
                Node newNode = new Node(current.count + 1);
                newNode.keys.add(key);
                insertAfterNode(newNode, current);
                next = newNode;
            }
            keysMap.put(key, next);
            if (current.keys.isEmpty()) {
                remove(current);
            }
        } else {
            if (head.next != tail && head.next.count == 1) {
                head.next.keys.add(key);
                keysMap.put(key, head.next);
            } else {
                Node node  = new Node(1);
                node.keys.add(key);
                insertAfterNode(node, head);
                keysMap.put(key, node);
            }
        }
    }
    
    public void dec(String key) {
        if (keysMap.containsKey(key)) {
            Node current = keysMap.get(key);
            current.keys.remove(key);
            Node prev = current.prev;
            if (current.count == 1) {
                keysMap.remove(key);
            } else {
                if (prev != head && prev.count == current.count -1) {
                    prev.keys.add(key);
                    keysMap.put(key, prev);
                } else {
                    Node node = new Node(current.count -1);
                    node.keys.add(key);
                    insertAfterNode(node, prev);
                    keysMap.put(key, node);
                }
            }
            if (current.keys.isEmpty()) {
                remove(current);
            }
        }
    }
    
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    private void insertAfterNode(Node current, Node node) {
        current.next = node.next;
        node.next.prev = current;
        current.prev = node;
        node.next = current;
    }

    private void remove(Node node) {
        node.prev.next =node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int count;
    Set<String> keys;
    Node next;
    Node prev;
    public Node(int count) {
        this.count= count;
        this.keys = new HashSet<>();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */