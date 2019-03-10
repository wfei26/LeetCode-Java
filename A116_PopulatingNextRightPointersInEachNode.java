public class A116_PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        A116_PopulatingNextRightPointersInEachNode solution = new A116_PopulatingNextRightPointersInEachNode();
        int[] myInputs = {1,2,3,4,5,6,7};
        Node myTree = solution.sortedArrayToBST(myInputs);
        solution.connect(myTree);
    }

    public Node sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        Node newTree = helpers(nums, 0, nums.length - 1);
        return newTree;
    }

    public Node helpers(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        Node newNode = new Node(num[mid]);
        newNode.left = helpers(num, low, mid - 1);
        newNode.right = helpers(num, mid + 1, high);
        return newNode;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node parent = root;
        while (parent != null) {
            // curParent trace the parent node on the parent level
            Node curParent = parent;
            // curNode trace the child node on the child level
            Node curNode = curParent.left;
            while (curNode != null) {
                // connect left and right
                curNode.next = curParent.right;
                curNode = curNode.next;
                // connect right and next left if necessary
                if (curParent.next != null) {
                    curParent = curParent.next;
                    curNode.next = curParent.left;
                }
                curNode = curNode.next;
            }
            parent = parent.left;
        }
        return root;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int x) {val = x;}
    }
}
