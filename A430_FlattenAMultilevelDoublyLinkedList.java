public class A430_FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        A430_FlattenAMultilevelDoublyLinkedList solution = new A430_FlattenAMultilevelDoublyLinkedList();
    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    /** dfs() always return tail of current list
     * if curNode does not have child, we only need to linearly traverse the entire list until reach the end
     * if curNode has child, we need to connect current node with its child node, and then find tail of child
     * list, to connect child tail with its nextNode */
    public Node dfs(Node curNode) {
        if (curNode == null) {
            return null;
        }

        // if curNode does not have child
        if (curNode.child == null) {
            // if curNode is the tail of current list
            if (curNode.next == null) {
                return curNode;
            }
            // if curNode still have other nodes behind
            else {
                return dfs(curNode.next);
            }
        }

        // if curNode has child
        else {
            Node childNode = curNode.child;
            Node nextNode = curNode.next;
            Node childTail = dfs(childNode);

            // WARNING: MUST set child as null, since we only want to create a single linked list as result
            // without any children
            curNode.child = null;

            curNode.next = childNode;
            childNode.prev = curNode;

            // if parent node has next node, flatten the child, connect it with the next, then go next
            // until reach the end
            if (nextNode != null) {
                childTail.next = nextNode;
                nextNode.prev = childTail;
                return dfs(nextNode);
            }
            // if parent node does not have next node, flatten the child and return tail of child
            return childTail;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}

