import java.util.HashMap;

public class A106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        A106_ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new A106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode myResult = solution.buildTree(preorder, inorder);
        System.out.println(myResult);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder, map);
    }

    public TreeNode buildTreeHelper(int postOrderEnd, int inOrderStart, int inOrderEnd,
                                    int[] postorder, int[] inorder, HashMap<Integer, Integer> map) {
        if (inOrderStart > inOrderEnd || postOrderEnd < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postOrderEnd]);
        int inOrderIndex = map.get(root.val);
        root.left = buildTreeHelper(postOrderEnd - (inOrderEnd - inOrderIndex) - 1, inOrderStart, inOrderIndex - 1, postorder, inorder, map);
        root.right = buildTreeHelper(postOrderEnd - 1, inOrderIndex + 1, inOrderEnd, postorder, inorder, map);
        return root;
    }
}
