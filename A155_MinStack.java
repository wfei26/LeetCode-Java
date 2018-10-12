import java.util.Stack;

public class A155_MinStack {
    public static void main(String[] args) {
        A155_MinStack myMinStack = new A155_MinStack();
        myMinStack.push(1);
        myMinStack.push(2);
        myMinStack.top();
        myMinStack.getMin();
        myMinStack.pop();
        myMinStack.getMin();
        myMinStack.top();
    }

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public A155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //if new item is smaller than previous min (from top of minStack)
        //then assign x to curMin, and then push to both of stack and minStack
        //if new item is smaller than or equal to previous min element
        //still push previous min to the min stack to keep the same size between minStack and stack
        int curMin = Integer.MAX_VALUE;
        if (!minStack.isEmpty()) {
            curMin = minStack.peek();
        }
        if (x < curMin) {
            curMin = x;
        }
        stack.push(x);
        minStack.push(curMin);
    }

    public void pop() {
        //Keep size of two stacks same, always pop both of them
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
