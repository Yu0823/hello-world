package Algorithm;

import java.util.HashMap;

class LRUCache {

    int capacity;

    int now;

    HashMap<Integer, Integer> m;

    DLLNode head;

    DLLNode tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        this.now = 0;

        m = new HashMap();

        head = new DLLNode(-1);

        tail = new DLLNode(-2);

        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        int ans = m.getOrDefault(key, -1);
        //find
        if(ans != -1){
            moveToHead(key);
        }
        return ans;
    }

    public void put(int key, int value) {
        if(m.containsKey(key)){
            m.put(key, value);
            moveToHead(key);
        }
        else{
            if(now >= capacity){
                delTail();
            }
            addToHead(key);
            m.put(key, value);
            now++;
        }
    }

    public void addToHead(int key){
        DLLNode in = new DLLNode(key);

        in.next = head.next;
        in.prev = head;
        head.next.prev = in;
        head.next = in;
    }

    public void moveToHead(int key){
        DLLNode p = head.next;
        while(p != tail){
            if(p.key == key)
                break;
            p = p.next;
        }

        p.prev.next = p.next;
        p.next.prev = p.prev;
        p.prev = head;
        p.next = head.next;
        head.next.prev = p;
        head.next = p;
    }

    public void delTail(){
        int key = tail.prev.key;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;

        m.remove(key);
    }

    class DLLNode{
        int key;

        DLLNode prev;

        DLLNode next;

        public DLLNode(){}

        public DLLNode(int key){
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
        return;
    }
}
