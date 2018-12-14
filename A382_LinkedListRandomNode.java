import java.util.Random;

public class A382_LinkedListRandomNode {
    public static void main(String[] args) {
        // Init a singly linked list [1,2,3].
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        A382_LinkedListRandomNode solution = new A382_LinkedListRandomNode(head);
        // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
        int output = solution.getRandom();
        System.out.println(output);
    }

    /*
     * When we read the first node head, if the stream ListNode stops here, we can just return the head.val.
     * The possibility is 1/1.
     *
     * When we read the second node, we can decide if we replace the result r or not. The possibility is 1/2.
     * So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1,
     * replace r as the value of the current node, otherwise we don't touch r, so its value is still the value of head.
     *
     * When we read the third node, now the result r is one of value in the head or second node.
     * We just decide if we replace the value of r as the value of current node(third node).
     * The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3.
     * So we just generate a random number between 0 ~ 2, and if the result is 2 we replace r.
     * We can continue to do like this until the end of stream ListNode.
     *
     * Reference: http://blog.jobbole.com/42550/
    * */
    ListNode head;
    Random random;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public A382_LinkedListRandomNode(ListNode h) {
        head = h;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curNode = head;
        int result = curNode.val;
        for(int i = 1; curNode.next != null; i++){
            curNode = curNode.next;
            // increase random range by 1 in every iteration
            if(random.nextInt(i + 1) == i) {
                result = curNode.val;
            }
        }
        return result;
    }
}
