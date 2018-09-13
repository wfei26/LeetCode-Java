import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A652_FindDuplicateSubtrees {
    public static void main(String[] args) {
        A652_FindDuplicateSubtrees solution = new A652_FindDuplicateSubtrees();
        int[] myInputs = {1,2,2,3,3};
        TreeNode myTree = solution.createBinaryTree();
        List<TreeNode> myResults = solution.findDuplicateSubtrees(myTree);
        for (int i = 0; i < myResults.size(); i++) {
            System.out.println(myResults.get(i).val);
        }
    }

    public TreeNode createBinaryTree() {
        TreeNode newTree = new TreeNode(0);
        newTree.left = new TreeNode(0);
        newTree.left.left = new TreeNode(0);
        newTree.right = new TreeNode(0);
        newTree.right.left = new TreeNode(0);
        newTree.right.right = new TreeNode(0);
        newTree.right.left.left = new TreeNode(0);
        return newTree;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        postOrder(root, new HashMap<>(), results);
        return results;
    }

    public String postOrder(TreeNode curNode, Map<String, Integer> map, List<TreeNode> myList) {
        if (curNode == null) {
            return "";
        }
        //serialize the tree recursively
        //recursion process for the example [1,2,3,4,null,2,4,null,null,4]:
        //serialTree = 4nn => 24nnn => 4nn => 24nnn => 4nn => 324nnn4nn => 124nnn324nnn4nn
        String serialTree = curNode.val + postOrder(curNode.left, map, myList) + postOrder(curNode.right, map, myList);

        //add the tree root to result list only if map value is equal to 1 to avoid duplicate
        //eg: if we have 3 same subtrees, we only add one time
        if (map.getOrDefault(serialTree, 0) == 1) {
            myList.add(curNode);
        }
        map.put(serialTree, map.getOrDefault(serialTree, 0) + 1);
        return serialTree;
    }
}
