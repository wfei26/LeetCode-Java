import java.util.HashMap;

public class A146_LRUCache {
    public static void main(String[] args) {
        A146_LRUCache cache = new A146_LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    int capacity; //maximum size of cache
    int curSize; //current size of cache
    HashMap<Integer, DoubleListNode> cache;
    DoubleListNode head;
    DoubleListNode tail;

    public A146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        cache = new HashMap<>();

        head = new DoubleListNode();
        tail = new DoubleListNode();

        //DO NOT FORGET to connect head and tail together
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleListNode curNode = cache.get(key);
        //check if cache contains this key
        if (curNode == null) {
            return -1;
        }
        //move most recent accessing node to head if it exists
        moveToHead(curNode);
        return curNode.value;
    }

    public void put(int key, int value) {
        DoubleListNode curNode = cache.get(key);
        if (curNode == null) {
            curSize++;
            //check if cache size over the capacity
            if (curSize > capacity) {
                //remove tail node from both of linked list and map
                DoubleListNode removeNode = removeTail();
                cache.remove(removeNode.key);
                //DO NOT FORGET to minus current size by 1
                curSize--;
            }
            DoubleListNode newNode = new DoubleListNode();
            newNode.key = key;
            newNode.value = value;
            //add node to both of linked list and map
            addNode(newNode);
            cache.put(key, newNode);
        }
        else {
            curNode.value = value;
            //update least recent cache list
            moveToHead(curNode);
            //update cache map value
            cache.put(key, curNode);
        }
    }

    public void addNode(DoubleListNode newNode) {
        DoubleListNode nextNode = head.next;

        //two way connections
        newNode.next = nextNode;
        newNode.prev = head;

        nextNode.prev = newNode;
        head.next = newNode;
    }

    public void deleteNode(DoubleListNode curNode) {
        DoubleListNode prevNode = curNode.prev;
        DoubleListNode nextNode = curNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void moveToHead(DoubleListNode curNode) {
        deleteNode(curNode);
        addNode(curNode);
    }

    public DoubleListNode removeTail() {
        DoubleListNode curNode = tail.prev;
        deleteNode(curNode);
        //we need to return removing node since we have to get the node information
        //to remove corresponding key in cache map
        return curNode;
    }

    class DoubleListNode {
        int key;
        int value;
        DoubleListNode prev;
        DoubleListNode next;
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}

