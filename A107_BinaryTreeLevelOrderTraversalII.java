import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A107_BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        A107_BinaryTreeLevelOrderTraversalII solution = new A107_BinaryTreeLevelOrderTraversalII();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<List<Integer>> myResult = solution.levelOrderBottom(myTree);
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                //peek() firstly!!!
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                //then pop()!!!
                curList.add(queue.poll().val);
            }
            results.add(0, curList);
        }
        return results;
    }
}
