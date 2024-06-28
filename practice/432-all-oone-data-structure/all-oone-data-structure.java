class AllOne {
    Map<String, Node> keysMap;
    Node head, tail;

    public AllOne() {
        this.keysMap = new HashMap<>();
        this.head = new Node(Integer.MIN_VALUE);
        this.tail = new Node(Integer.MAX_VALUE);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public void inc(String key) {
        if(keysMap.containsKey(key)) {
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
            if (head.next.count == 1) {
                head.next.keys.add(key);
                keysMap.put(key, head.next);
            } else {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                insertAfterNode(newNode, head);
                keysMap.put(key, newNode);
            }
        }
    }
    
    public void dec(String key) {
        if (keysMap.containsKey(key)) {
            Node current = keysMap.get(key);
            current.keys.remove(key);
            if (current.count == 1) {
                keysMap.remove(key);
            } else {
                Node prev = current.prev;
                if (prev != head && prev.count == current.count -1) {
                    prev.keys.add(key);
                } else {
                    Node node = new Node(current.count -1);
                    node.keys.add(key);
                    insertAfterNode(node, prev);
                    prev = node;
                }
                keysMap.put(key, prev);
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
        // System.out.println("max key: " + tail.prev.count  + " " + tail.prev.keys.toString());
        // Node current = head;
        // while (current != null) {
        //     System.out.println(current.count + " " + current.keys.toString());
        //     current = current.next;
        // }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        // System.out.println("min key: " + head.next.count + " " + head.next.keys.toString());
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
    Node prev;
    Node next;
    public Node(int count) {
        this.count = count;
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
 l - 3
 k - 2
 j - 2
 */