import java.util.LinkedList;
import java.util.Queue;

public class A297_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        A297_SerializeAndDeserializeBinaryTree solution = new A297_SerializeAndDeserializeBinaryTree();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        String output = solution.serialize(myTree);
        System.out.println(output);
        TreeNode treeOutput = solution.deserialize(output);
        solution.preOrderPrint(treeOutput);
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

    public void preOrderPrint(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        System.out.print(curNode.val + " ");
        preOrderPrint(curNode.left);
        preOrderPrint(curNode.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }

        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.substring(0, result.length() - 1);
    }

    //preorder traversal template
    public void serializeHelper(TreeNode curNode, StringBuilder result) {
        //recursion exit
        if (curNode == null) {
            result.append("N,");
        }
        else {
            result.append(String.valueOf(curNode.val) + ",");
            serializeHelper(curNode.left, result);
            serializeHelper(curNode.right, result);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //use queue to store split node, then we can build tree again by preorder traversal
        //here, we pass an array with length 1 instead of int value,
        //because array is pass by reference, then we can recursively change values
        TreeNode newTree = deserializeHelper(data.split(","), new int[1]);
        return newTree;
    }

    public TreeNode deserializeHelper(String[] nodeList, int[] curIndex) {
        //WARNING: USE .equals() at here
        if (nodeList[curIndex[0]].equals("N")) {
            curIndex[0]++;
            return null;
        }
        //WARNING: MUST USE else at here
        //different with other normal recursive call, we can only enter one condition at here
        //either null or valid value because we only poll one item from queue for each recursion
        else {
            TreeNode newNode = new TreeNode(Integer.valueOf(nodeList[curIndex[0]]));
            //here, we only need to plus 1 for traversal index one time per single recursive call
            curIndex[0]++;
            newNode.left = deserializeHelper(nodeList, curIndex);
            newNode.right = deserializeHelper(nodeList, curIndex);
            return newNode;
        }
    }
}
