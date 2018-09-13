import java.util.List;

public class A437_PathSumIII {
    public static void main(String[] args) {
        A437_PathSumIII solution = new A437_PathSumIII();
        int[] myInputs = {1,1,2,2,3,4,5,6};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.pathSum(myTree, 6);
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

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSumHelper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (sum == node.val) {
            count++;
        }
        count += pathSumHelper(node.left, sum - node.val) + pathSumHelper(node.right, sum - node.val);
        return count;
    }
}
