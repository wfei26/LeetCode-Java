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

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    /** Initialize your data structure here. */
    public A232_ImplementQueueUsingStacks() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stackB.pop();
    }

    /** Get the front element. */
    /** Armotized O(1) */
    public int peek() {
        if (empty()) {
            return -1;
        }
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
