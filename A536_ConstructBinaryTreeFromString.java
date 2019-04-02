public class A536_ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        A536_ConstructBinaryTreeFromString solution = new A536_ConstructBinaryTreeFromString();
    }

    /** use divide and conquer to recursively build left subtree and right subtree. In every recursion step, we get root
     * firstly, and then count balanced parentheses to get left substring for left subtree and right substring for
     * right subtree */
    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }

        int i = 0, j = 0;

        // get root value
        while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-')) {
            j++;
        }
        int rootVal = Integer.parseInt(s.substring(i, j));
        TreeNode root = new TreeNode(rootVal);

        // get left substring: start from first parentheses to count number of left parentheses and right parentheses
        // until the count value gets balanced
        i = j;
        int countParent = 0;
        if (j < s.length()) {
            while (j < s.length()) {
                if (s.charAt(j) == '(') {
                    countParent++;
                }
                else if (s.charAt(j) == ')') {
                    countParent--;
                }
                if (countParent == 0) {
                    break;
                }
                j++;
            }
            // left subtree should start from left boundary + 1, since we cannot include left parentheses
            root.left = str2tree(s.substring(i + 1, j));
        }

        // get right substring: left boundary should be j + 2 since we cannot include last right parentheses of left
        // string and first left parentheses of right substring
        j++;
        if (j < s.length()) {
            root.right = str2tree(s.substring(j + 1, s.length() - 1));
        }
        return root;
    }
}
