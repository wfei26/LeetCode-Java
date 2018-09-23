public class A255_VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {
        A255_VerifyPreorderSequenceInBinarySearchTree solution = new A255_VerifyPreorderSequenceInBinarySearchTree();
        int[] inputs = {5,2,6,1,3};
        boolean output = solution.verifyPreorder(inputs);
        System.out.println(output);
    }

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return false;
        }

        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}