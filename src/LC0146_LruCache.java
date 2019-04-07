import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC0146_LruCache {

    public static void main(String[] args) {
        new LC0146_LruCache();
    }

    public LC0146_LruCache() {
//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);                        // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);                        // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

        LRUCache cache2 = new LRUCache(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        cache2.get(1); // 1
        cache2.put(3, 3);
        cache2.get(2); // -1
        cache2.put(4, 4);
        cache2.get(1);
        cache2.get(3);
        cache2.get(4);


    }

    private class LRUCache {

        private Map<Integer, Integer> cache = new HashMap<>();
        private Queue<Integer> order = new LinkedList<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            System.out.println("Getting " + key);
            return cache.getOrDefault(key, -1);
         }

        public void put(int key, int value) {

            System.out.println("Putting (" + key + ", " + value + ")");

            if (capacity == cache.size()) {
                int toRemove = order.remove();
                System.out.println("Removing key " + toRemove);
                cache.remove(toRemove);
            }

            cache.put(key, value);
            order.add(key);

        }

    }

}


