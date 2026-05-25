class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = map.remove(key); // remove返回删除值或者空，所以必须用包装类Integer
        if (value != null) {
            map.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Integer v = map.remove(key);
        if (v != null) {
            map.put(key, value);
        } else {
            if (map.size() == capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */