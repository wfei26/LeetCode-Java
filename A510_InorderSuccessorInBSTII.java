public class A510_InorderSuccessorInBSTII {
    public static void main(String[] args) {
        A510_InorderSuccessorInBSTII solution = new A510_InorderSuccessorInBSTII();
    }

    /**
     * we separate two cases to solve the problem:
     * 1. when input node has right subtree: return the smallest value of entire right subtree
     * 2. when input node does not have right subtree, iteratively find its parent and its ancestors
     * until find the first greater parent of input node
     * */
    public Node inorderSuccessor(Node x) {
        if (x == null) {
            return null;
        }
        Node curNode = x;
        if (curNode.right != null) {
            Node rightMin = curNode.right;
            while (rightMin.left != null) {
                rightMin = rightMin.left;
            }
            return rightMin;
        }
        else {
            Node curParent = x.parent;
            while (curParent != null && curParent.val < x.val) {
                curParent = curParent.parent;
            }
            return curParent;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
