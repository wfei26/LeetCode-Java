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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA, p2 = headB;
        /*
        * we use two pass to traverse both of two linked list
        * 1. in the first pass, we find the length difference between two lists
        *   - if one of them reaches the end earlier then reuse it by moving it to the beginning of other list
        *   - once both of them go through reassigning, we will start the second pass since they are equal distance
        *   to the intersection point
        * 2. in the second pass, start traversing two list simultaneously until they reach the same node
        *   - if two linked list intersects, the meeting point in second iteration must be the intersection point
        *   - if the two linked lists have no intersection at all, then the meeting pointer in second iteration
        *   must be the tail node of both lists, which is null
        * */
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
