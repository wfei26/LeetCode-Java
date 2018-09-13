import java.util.HashMap;

public class A105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        A105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new A105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode myResult = solution.buildTree(preorder, inorder);
        System.out.println(myResult);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(0, 0, inorder.length - 1, preorder, inorder, map);
    }

    public TreeNode buildTreeHelper(int preOrderStart, int inOrderStart, int inOrderEnd,
                                    int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (inOrderStart > inOrderEnd || preOrderStart > preorder.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preOrderStart]);
        int inOrderIndex = map.get(root.val);
        root.left = buildTreeHelper(preOrderStart + 1, inOrderStart, inOrderIndex - 1, preorder, inorder, map);
        root.right = buildTreeHelper(preOrderStart + inOrderIndex - inOrderStart + 1, inOrderIndex + 1, inOrderEnd, preorder, inorder, map);
        return root;
    }
}
