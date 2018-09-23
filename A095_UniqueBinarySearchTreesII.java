import java.util.ArrayList;
import java.util.List;

public class A095_UniqueBinarySearchTreesII {
    public static void main (String[] args) {
        A230_KthSmallestElementInABST solution = new A230_KthSmallestElementInABST();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.kthSmallest(myTree, 3);
        System.out.println(myResult);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
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

    public List<TreeNode> generateTrees(int n) {

    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> newList = new ArrayList<>();
        if (start > end) {
            newList.add(null);
            return newList;
        }

        List<TreeNode> left, right;
        for (int i = start; i < end; i++) {

        }
    }
}
