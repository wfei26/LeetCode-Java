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

    int curIndex = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }

        StringBuilder result = new StringBuilder();
        serializeHelper(root, result);
        return result.substring(0, result.length() - 1);
    }

    // preorder traversal
    public void serializeHelper(TreeNode curNode, StringBuilder result) {
        if (curNode == null) {
            result.append("N,");
            return;
        }
        else {
            result.append(curNode.val + ",");
            serializeHelper(curNode.left, result);
            serializeHelper(curNode.right, result);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // we can build tree again by preorder traversal
        TreeNode newTree = deserializeHelper(data.split(","));
        return newTree;
    }

    public TreeNode deserializeHelper(String[] nodeList) {
        if (nodeList[curIndex].equals("N")) {
            curIndex++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(nodeList[curIndex]));
        // we only need to plus 1 for traversal index one time per single recursive call
        curIndex++;
        root.left = deserializeHelper(nodeList);
        root.right = deserializeHelper(nodeList);
        return root;
    }
}
