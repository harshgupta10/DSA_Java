class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }


    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key,value);
            return;
        }
        //注意链头就是最没用的
        if (cache.size() >= cap) {
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
            
        }
        cache.put(key,value);
        //没有必要是因为put本来就在最后
        //makeRecently(key);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */