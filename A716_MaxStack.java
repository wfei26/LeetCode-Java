import java.util.Stack;

public class A716_MaxStack {
    public static void main(String[] args) {
        A716_MaxStack myStack = new A716_MaxStack();
        myStack.push(5);
        myStack.push(1);
        myStack.popMax();
        myStack.peekMax();
    }

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public A716_MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        //define a curMax to save the max value, in order to
        //trace current value (whether from previous max stack or new item)
        int curMax = 0;
        if (maxStack.isEmpty()) {
            curMax = Integer.MIN_VALUE;
        }
        else {
            curMax = maxStack.peek();
        }

        //update the current max if new item is greater than
        //top element of max stack
        if (x > curMax) {
            curMax = x;
        }
        //push new item into both of two stacks to keep
        //concurrency (same size) of two stacks
        stack.push(x);
        maxStack.push(curMax);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        //Use a temp stack to help main stack save elements,
        //and then push them back to main stack after taking
        //max elements from main stack
        Stack<Integer> tempStack = new Stack<>();
        int curMax = maxStack.peek();
        while (stack.peek() != curMax) {
            tempStack.push(stack.pop());
            maxStack.pop();
        }

        //DO NOT FORGET to pop elements from both of two stacks
        stack.pop();
        maxStack.pop();

        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
        return curMax;
    }
}
