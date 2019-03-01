public class A708_InsertIntoACyclicSortedList {
    public static void main(String[] args) {
        A708_InsertIntoACyclicSortedList solution = new A708_InsertIntoACyclicSortedList();
    }

    /** maintain an infinite loop, trying to find the insert location. Once find it, we can break the loop */
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            return new Node(insertVal, null);
        }

        Node curNode = head;
        while (curNode != null) {
            // condition 1: two consecutive nodes are still in ascending order, check if new node is between them
            if (curNode.val < curNode.next.val) {
                if (insertVal >= curNode.val && insertVal <= curNode.next.val) {
                    Node newNode = new Node(insertVal, curNode.next);
                    curNode.next = newNode;
                    break;
                }
            }

            // condition 2: one node is the last node, another one is the first node of all sorted list, check if
            // new node is greater than last node OR smaller than first node
            else if (curNode.val > curNode.next.val) {
                if (insertVal >= curNode.val || insertVal <= curNode.next.val) {
                    Node newNode = new Node(insertVal, curNode.next);
                    curNode.next = newNode;
                    break;
                }
            }

            // condition 3: two consecutive nodes are equal, we can only insert new node at the head. Because only if
            // we cannot find a correct insertion place after traverse all of nodes, we are able to insert this node at head
            else {
                if (curNode.next == head) {
                    Node newNode = new Node(insertVal, curNode.next);
                    curNode.next = newNode;
                    break;
                }
            }
            curNode = curNode.next;
        }
        return head;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    };
}
