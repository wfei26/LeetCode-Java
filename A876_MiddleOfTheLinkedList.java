public class A876_MiddleOfTheLinkedList {
    public static void main(String[] args) {
        A876_MiddleOfTheLinkedList solution = new A876_MiddleOfTheLinkedList();
        ListNode input = new ListNode(1);
        ListNode curNode = input;
        for (int i = 2; i <= 6; i++, curNode = curNode.next) {
            curNode.next = new ListNode(i);
        }
        ListNode output = solution.middleNode(input);
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        // FAST-SLOW POINTER is the best way to find middle point of a linked list!!!
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
