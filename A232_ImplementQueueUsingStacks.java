import java.util.Stack;

public class A232_ImplementQueueUsingStacks {
    public static void main(String[] args) {
        A232_ImplementQueueUsingStacks myStack = new A232_ImplementQueueUsingStacks();
        myStack.push(1);
        myStack.push(2);
        myStack.peek();
        myStack.pop();
        myStack.empty();
    }

    Stack<Integer> queue;

    /** Initialize your data structure here. */
    public A232_ImplementQueueUsingStacks() {
        queue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();
        while (!queue.isEmpty()) {
            tempStack.push(queue.pop());
        }
        queue.push(x);
        while (!tempStack.isEmpty()) {
            queue.push(tempStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
