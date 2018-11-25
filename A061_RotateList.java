public class A061_RotateList {
    public static void main(String[] args) {
        A061_RotateList solution = new A061_RotateList();
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);

        ListNode output = solution.rotateRight(input, 2);
        ListNode curNode = output;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // CAUTION: MUST assign dummy to fullPtr, DO NOT ASSIGN head to endPtr
        // since we want to traverse with condition "endPtr.next != null," we do not want to endPtr to be null
        // so that we cannot use endPtr to connect with head later
        ListNode newHeadPtr = dummy, endPtr = dummy;

        // count length of linked list
        int len = 0;
        // MUST traverse with "endPtr.next != null"
        while (endPtr.next != null) {
            len++;
            endPtr = endPtr.next;
        }

        // midLen represents the position of new head we want to move to front
        int midLen = len - k % len;
        while (midLen != 0) {
            newHeadPtr = newHeadPtr.next;
            midLen--;
        }

        // connect endPtr with  previous head
        endPtr.next = dummy.next;
        // connect dummy with new head
        dummy.next = newHeadPtr.next;
        newHeadPtr.next = null;
        return dummy.next;
    }
}
