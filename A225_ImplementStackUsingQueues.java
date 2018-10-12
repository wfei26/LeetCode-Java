import java.util.LinkedList;
import java.util.Queue;

public class A225_ImplementStackUsingQueues {
    public static void main(String[] args) {
        A225_ImplementStackUsingQueues stack = new A225_ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false
    }

    Queue<Integer> stack;
    /** Initialize your data structure here. */
    public A225_ImplementStackUsingQueues() {
        stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.offer(x);
        //adjust new item to the front of queue.
        //when you do pop() or peek(), it will return the most recent adding item
        for (int i = 0; i < stack.size() - 1; i++) {
            stack.offer(stack.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
