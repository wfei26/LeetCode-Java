import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        A103_BinaryTreeZigzagLevelOrderTraversal solution = new A103_BinaryTreeZigzagLevelOrderTraversal();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<List<Integer>> myResult = solution.zigzagLevelOrder(myTree);
        for (int i = 0; i < myResult.size(); i++) {
            for (int item : myResult.get(i)) {
                System.out.println(item);
            }
            System.out.println("-------------------------");
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        TreeNode newTree = helpers(nums, 0, nums.length - 1);
        return newTree;
    }

    public TreeNode helpers(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode newNode = new TreeNode(num[mid]);
        newNode.left = helpers(num, low, mid - 1);
        newNode.right = helpers(num, mid + 1, high);
        return newNode;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (reverse) {
                    curList.add(0, queue.poll().val);
                }
                else {
                    curList.add(queue.poll().val);
                }
            }
            reverse = !reverse;
            results.add(curList);
        }
        return results;
    }
}
