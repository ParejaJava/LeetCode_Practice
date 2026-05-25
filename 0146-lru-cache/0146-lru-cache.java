class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private Node dummy = new Node(0, 0);
    private Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }
    
    public int get(int key) { // 这个函数目的是查看key对应的value并且把这对kv放到链表头
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }
    
    public void put(int key, int value) { // 这个函数的目的是：如果有这个key更新值并提前即可
    // 没有这个key的话需要新建一个节点然后放在头部
        Node node = getNode(key);// 此时已经移动到头部
        if (node != null) {
            node.value = value;// 修改为新值
            return;
        }
        node = new Node(key, value); // 没有这个节点要新建
        keyToNode.put(key, node); // 同时也要存入哈希表，因为需要o1查找
        pushFront(node); // 放到链表头
        if (keyToNode.size() > capacity) {// 看看有没有超过容限
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode); // 找到尾部节点删掉，在字典里也一并删掉
        }
    }

    private Node getNode(int key) { //没key就返回空，有key要“抽出”然后“放到头部”
        if (!keyToNode.containsKey(key)) {
            return null;
        }
        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove (Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront (Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        dummy.next = x;
        x.next.prev = x;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */