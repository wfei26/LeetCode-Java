public class A002_AddTwoNumbers {
    public static void main(String[] args) {
        A002_AddTwoNumbers solution = new A002_AddTwoNumbers();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = solution.addTwoNumbers(l1, l2);
        ListNode curNode = l3;
        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode curL1 = l1, curL2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        int sum = 0;

        while (curL1 != null || curL2 != null) {
            if (curL1 != null) {
                sum += curL1.val;
                curL1 = curL1.next;
            }
            if (curL2 != null) {
                sum += curL2.val;
                curL2 = curL2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            curNode.next = newNode;
            curNode = curNode.next;
            // update sum to 1 if sum is greater than 9
            sum = sum / 10;
        }
        // if last sum is still greater than 9, add a new node
        if (sum == 1) {
            curNode.next = new ListNode(1);
        }
        return dummy.next;
    }
}
