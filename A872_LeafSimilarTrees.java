public class A872_LeafSimilarTrees {
    public static void main(String[] args) {
        A872_LeafSimilarTrees solution = new A872_LeafSimilarTrees();
    }

    /** traverse two trees, respectively. Encode tree values into stringbuilder and compare two results */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        traverse(sb1, root1);
        traverse(sb2, root2);
        return sb1.toString().equals(sb2.toString());
    }

    public void traverse(StringBuilder sb, TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        if (curNode.left == null && curNode.right == null) {
            sb.append(curNode.val + "#");
            return;
        }
        traverse(sb, curNode.left);
        traverse(sb, curNode.right);
    }
}
