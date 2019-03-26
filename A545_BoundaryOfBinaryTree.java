import java.util.ArrayList;
import java.util.List;

public class A545_BoundaryOfBinaryTree {
    public static void main(String[] args) {
        A545_BoundaryOfBinaryTree solution = new A545_BoundaryOfBinaryTree();
        TreeNode myTree = new TreeNode(1);
        myTree.right = new TreeNode(2);
        myTree.right.left = new TreeNode(3);
        myTree.right.right = new TreeNode(4);

        List<Integer> myResult = solution.boundaryOfBinaryTree(myTree);
        System.out.println(myResult);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        results.add(root.val);
        traverseLeft(results, root.left);
        //we cannot traverse directly bottom from root, it will count duplicate sometime
        //eg: for the input 1, the output will be [1,1], but the correct output should be [1]
        traverseBottom(results, root.left);
        traverseBottom(results, root.right);
        traverseRight(results, root.right);
        return results;
    }

    public void traverseLeft(List<Integer> myList, TreeNode curNode) {
        if (curNode == null || curNode.left == null && curNode.right == null) {
            return;
        }
        //add the node from by top-down order, so the add function should be in front of recursion
        myList.add(curNode.val);
        if (curNode.left == null) {
            traverseLeft(myList, curNode.right);
        }
        else {
            traverseLeft(myList, curNode.left);
        }
    }

    public void traverseRight(List<Integer> myList, TreeNode curNode) {
        if (curNode == null || curNode.left == null && curNode.right == null) {
            return;
        }
        if (curNode.right == null) {
            traverseRight(myList, curNode.left);
        }
        else {
            traverseRight(myList, curNode.right);
        }
        //add the node by bottom-up order, so the add function should be after recursion
        myList.add(curNode.val);
    }

    public void traverseBottom(List<Integer> myList, TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        if (curNode.left == null && curNode.right == null) {
            myList.add(curNode.val);
            return;
        }
        traverseBottom(myList, curNode.left);
        traverseBottom(myList, curNode.right);
    }
}
