public class A622_DesignCircularQueue {
    public static void main(String[] args) {
        A622_DesignCircularQueue solution = new A622_DesignCircularQueue(3);
    }

    public int[] queue;
    private int frontIndex; // store current front position
    private int rearIndex; // store current rear position (it can be greater than size)
    private int curSize;
    private int capacity;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public A622_DesignCircularQueue(int k) {
        queue = new int[k];
        frontIndex = 0;
        rearIndex = -1;
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!isFull()) {
            rearIndex++;
            rearIndex %= capacity;
            queue[rearIndex] = value;
            curSize++;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        // we do not care about the inner structure of array, we only care if we are in the right position for
        // front index and rear index
        if (!isEmpty()) {
            frontIndex++;
            frontIndex %= capacity;
            curSize--;
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (!isEmpty()) {
            return queue[frontIndex];
        }
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (!isEmpty()) {
            return queue[rearIndex];
        }
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return curSize == capacity;
    }
}
