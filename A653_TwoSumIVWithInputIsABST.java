import java.util.ArrayList;
import java.util.List;

public class A653_TwoSumIVWithInputIsABST {
    public static void main(String[] args) {
        A653_TwoSumIVWithInputIsABST solution = new A653_TwoSumIVWithInputIsABST();
        int[] myInputs = {2,3,4,5,6,7};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        boolean myResult = solution.findTarget(myTree, 9);
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

    /** use inorder traversal to traverse bst, and store sorted nums into array, then use two pointers (from start
     * and end) to find two sum from the array */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> sortedNums = new ArrayList<>();
        inorderTraversal(root, sortedNums);
        for (int i = 0, j = sortedNums.size() - 1; i < j;) {
            if (sortedNums.get(i) + sortedNums.get(j) == k) {
                return true;
            }
            else if (sortedNums.get(i) + sortedNums.get(j) > k) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }

    public void inorderTraversal(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, nums);
        nums.add(root.val);
        inorderTraversal(root.right, nums);
    }
}
