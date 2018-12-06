public class A328_OddEvenLinkedList {
    public static void main(String[] args) {
        A328_OddEvenLinkedList solution = new A328_OddEvenLinkedList();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(7);

        l1.next.next.next.next = l2;

        ListNode output = solution.oddEvenList(l1);
        ListNode curNode = output;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddHead = odd;
        ListNode evenHead = even;

        // connect odd node to next odd node, as well as connecting even node to next even node
        // then reset odd and even node to next odd and even node, respectively, for next iteration
        while (odd != null && odd.next != null && even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // connect odd list and even list
        odd.next = evenHead;
        return oddHead;
    }
}
