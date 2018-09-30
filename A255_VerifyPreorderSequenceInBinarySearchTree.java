public class A255_VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {
        A255_VerifyPreorderSequenceInBinarySearchTree solution = new A255_VerifyPreorderSequenceInBinarySearchTree();
        int[] inputs = {5,2,1,3,4,6};
        boolean output = solution.verifyPreorder(inputs);
        System.out.println(output);
    }

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null) {
            return false;
        }

        //simulate array traversal as stack
        int i = -1, curLowVal = Integer.MIN_VALUE;
        for (int item : preorder) {
            //if the next item is less then current low value (greatest value of left subtree),
            //it is not a correct BST with this preorder list
            if (item < curLowVal) {
                return false;
            }

            //if the next number is greater than the number on the top of stack (current item in array)
            //pop all smaller ancestor values (substitute current array item to new greater item) until
            //we do not find any number smaller than new item
            while (i >= 0 && item > preorder[i]) {
                //set last executed item (greatest number of current left subtree) as lower bound
                curLowVal = preorder[i--];
            }

            //if the next number is smaller than the last "stack" value (current array item),
            //we are still in the left subtree of all stack nodes, so skip the loop above,
            //just push the new one onto the stack (replace current position to new item)
            preorder[++i] = item;
        }
        return true;
    }
}