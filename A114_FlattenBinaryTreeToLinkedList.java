import java.util.List;

public class A114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        A114_FlattenBinaryTreeToLinkedList solution = new A114_FlattenBinaryTreeToLinkedList();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        solution.flatten(myTree);
        TreeNode curNode = myTree;
        while(curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.right;
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

    private TreeNode prevNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        //find right most subtree
        flatten(root.right);
        //deal with left subtree until right subtree is done
        flatten(root.left);
        root.right = prevNode;
        root.left = null;
        prevNode = root;
    }
}
