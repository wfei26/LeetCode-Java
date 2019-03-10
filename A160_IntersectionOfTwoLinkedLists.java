public class A160_IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        A160_IntersectionOfTwoLinkedLists solution = new A160_IntersectionOfTwoLinkedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode l3 = new ListNode(10);
        l3.next = new ListNode(11);
        l3.next.next = new ListNode(12);

        l1.next.next = l3;
        l2.next.next.next = l3;

        ListNode output = solution.getIntersectionNode(l1, l2);
        ListNode curNode = output;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    /** len of A + len of B = len of B + len of A: traverse two linked list simultaneously, if the any linked list
     * reach the end (null), start from another list to continue. Same as the longer one. It is kind of like connect
     * two linked list together, and we have two same list. Then they must meet at some point */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            }
            else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            }
            else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
