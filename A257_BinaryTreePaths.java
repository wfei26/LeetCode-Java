import java.util.ArrayList;
import java.util.List;

public class A257_BinaryTreePaths {
    public static void main(String[] args) {
        A257_BinaryTreePaths solution = new A257_BinaryTreePaths();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        List<String> output = solution.binaryTreePaths(tree);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, "", root);
        return result;
    }

    public void dfs(List<String> result, String curPath, TreeNode curNode) {
        // we do not have to traverse to the very bottom until curNode == null
        // since the last node has different status, compare with previous node, we have to separate it
        if (curNode.left == null && curNode.right == null) {
            result.add(curPath + curNode.val);
            return;
        }

        if (curNode.left != null) {
            dfs(result, curPath + curNode.val + "->", curNode.left);
        }
        if (curNode.right != null) {
            dfs(result, curPath + curNode.val + "->", curNode.right);
        }
    }
}
