public class A426_ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public static void main(String[] args) {
        A426_ConvertBinarySearchTreeToSortedDoublyLinkedList solution = new A426_ConvertBinarySearchTreeToSortedDoublyLinkedList();
        Node tree = new Node(5, null, null);
        tree.left = new Node(2, null, null);
        tree.right = new Node(6, null, null);
        tree.left.left = new Node(1, null, null);
        tree.left.right = new Node(3, null, null);

        Node res = solution.treeToDoublyList(tree);
        System.out.println(res.val);
    }

    // we must set prevNode as globle value because we have to trace the last node of linked list
    // when we do inorder traversal, in order to connect last node with first node after recursion done
    Node prevNode = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        Node dummy = new Node(0, null, null);
        prevNode = dummy;
        inorder(root);

        // connect last node with first node
        prevNode.right = dummy.right;
        dummy.right.left = prevNode;
        return dummy.right;
    }

    public void inorder(Node curNode) {
        if (curNode == null) {
            return;
        }
        inorder(curNode.left);
        // connect prevNode with curNode, and then set curNode to prevNode for next recursion
        prevNode.right = curNode;
        curNode.left = prevNode;
        prevNode = curNode;
        inorder(curNode.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
