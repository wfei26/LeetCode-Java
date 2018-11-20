public class A450_DeleteNodeInABST {
    public static void main(String[] args) {
        A450_DeleteNodeInABST solution = new A450_DeleteNodeInABST();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        TreeNode output = solution.deleteNode(myTree, 3);
        solution.inOrder(output);
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

    // Recursively find the node that has the same value as the key,
    // while setting the left/right nodes equal to the returned subtree
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // recursive steps
        TreeNode curNode = root;
        if (curNode.val > key) {
            curNode.left = deleteNode(curNode.left, key);
        }
        else if (curNode.val < key) {
            curNode.right = deleteNode(curNode.right, key);
        }

        // recursive exit: Once the node is found, have to handle the below 4 cases
        else {
            // node doesn't have left or right -> return null
            if (curNode.left == null && curNode.right == null) {
                return null;
            }
            // node only has left subtree -> return the left subtree
            else if (curNode.left == null) {
                return curNode.right;
            }
            // node only has right subtree -> return the right subtree
            else if (curNode.right == null) {
                return curNode.left;
            }
            // node has both left and right -> find the minimum value in the right subtree,
            // set that value to the currently found node,
            // then recursively delete the minimum value in the right subtree
            else {
                TreeNode minNode = findMin(curNode.right);
                curNode.val = minNode.val;
                // after substitution, delete minNode in the right subtree of curNode
                curNode.right = deleteNode(curNode.right, minNode.val);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode curNode) {
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        return curNode;
    }

    public void inOrder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        inOrder(curNode.left);
        System.out.println(curNode.val);
        inOrder(curNode.right);
    }
}
