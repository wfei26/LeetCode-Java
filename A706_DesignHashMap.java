public class A706_DesignHashMap {
    public static void main(String[] args) {
        A706_DesignHashMap solution = new A706_DesignHashMap();
    }

    private ListNode[] hashmap = new ListNode[10000];

    /** Initialize your data structure here. */
    public A706_DesignHashMap() {
        hashmap = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int curIndex = getIndex(key);
        if (hashmap[curIndex] == null) {
            hashmap[curIndex] = new ListNode();
        }

        ListNode prevNode = find(hashmap[curIndex], key);
        // if map does not contains current key
        if (prevNode.next == null) {
            prevNode.next = new ListNode(key, value);
        }
        // if map contains input key
        else {
            prevNode.next.val = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int curIndex = getIndex(key);
        // if map does not contains current key
        if (hashmap[curIndex] == null) {
            return -1;
        }

        // find previous node of result node
        ListNode prevNode = find(hashmap[curIndex], key);
        return prevNode.next != null ? prevNode.next.val : -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int curIndex = getIndex(key);
        if (hashmap[curIndex] == null) {
            return;
        }

        ListNode prevNode = find(hashmap[curIndex], key);
        if (prevNode.next == null) {
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % hashmap.length;
    }

    private ListNode find(ListNode head, int key) {
        ListNode curNode = head;
        ListNode prevNode = null;
        while (curNode != null && curNode.key != key) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        return prevNode;
    }

    class ListNode {
        private int key;
        private int val;
        private ListNode next;

        public ListNode() {}

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
