import java.util.Stack;

public class A230_KthSmallestElementInABST {
    public static void main (String[] args) {
        A230_KthSmallestElementInABST solution = new A230_KthSmallestElementInABST();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.kthSmallest(myTree, 3);
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

    //classical inorder template
    //the inorder traversal will generate a sorted array in a valid BST
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();

            //once k is equal to 0, we find the correct element
            if (--k == 0) {
                return curNode.val;
            }
            curNode = curNode.right;
        }
        return curNode.val;
    }
}
