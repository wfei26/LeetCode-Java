import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A272_ClosestBinarySearchTreeValueII {
    public static void main(String[] args) {
        A272_ClosestBinarySearchTreeValueII solution = new A272_ClosestBinarySearchTreeValueII();
    }

    /**
     * Step 1: recursively push smaller node into smaller stack (keep next node as closer as target)
     * Step 2: recursively push larger node into larger stack (keep next node as closer as target)
     * Step 3: iteratively add k closest nodes by comparing top element of two stacks
     * */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> smaller = new Stack<>();
        Stack<TreeNode> larger = new Stack<>();
        pushSmaller(root, target, smaller);
        pushLarger(root, target, larger);

        List<Integer> res = new ArrayList<>();
        TreeNode cur = null;
        while (res.size() < k) {
            if (smaller.isEmpty() || (!larger.isEmpty() && larger.peek().val - target < target - smaller.peek().val)) {
                cur = larger.pop();
                res.add(cur.val);
                // WARNING: DO NOT FORGET to push right subtree into stack, since we never access the right subtree of
                // current top element when we recursively push nodes into stack. Because we always find the smaller
                // node (which is closer to target compare with current top node) as next node when we adding them into stack
                pushLarger(cur.right, target, larger);
            } else {
                cur = smaller.pop();
                res.add(cur.val);
                // WARNING: DO NOT FORGET to push right subtree into stack, since we never access the left subtree of
                // current top element when we recursively push nodes into stack. Because we always find the larger
                // node (which is closer to target compare with current top node) as next node when we adding them into stack
                pushSmaller(cur.left, target, smaller);
            }
        }
        return res;
    }

    private void pushSmaller(TreeNode node, double target,  Stack<TreeNode> stack) {
        while (node != null) {
            // if current node is smaller, we need to try to find whether there exists another larger node
            if (node.val < target) {
                stack.push(node);
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    private void pushLarger(TreeNode node, double target, Stack<TreeNode> stack) {
        while (node != null) {
            // if current node is larger, we need to try to find whether there exists another smaller node
            if (node.val >= target) {
                stack.push(node);
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }
}
