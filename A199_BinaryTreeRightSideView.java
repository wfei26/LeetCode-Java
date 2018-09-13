import java.util.ArrayList;
import java.util.List;

public class A199_BinaryTreeRightSideView {
    public static void main(String[] args) {
        A199_BinaryTreeRightSideView solution = new A199_BinaryTreeRightSideView();
        int[] myInputs = {1,2,3,4,5};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<Integer> myResult = solution.rightSideView(myTree);
        System.out.println(myResult);
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        dfs(results, root, 0);
        return results;
    }

    public void dfs(List<Integer> myList, TreeNode curNode, int curLevel) {
        if (curNode == null) {
            return;
        }

        if (curLevel == myList.size()) {
            myList.add(curNode.val);
        }

        dfs(myList, curNode.right, curLevel + 1);
        dfs(myList, curNode.left, curLevel + 1);
    }
}
