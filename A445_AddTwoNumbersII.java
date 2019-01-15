import java.util.List;
import java.util.Stack;

public class A445_AddTwoNumbersII {
    public static void main(String[] args) {
        A445_AddTwoNumbersII solution = new A445_AddTwoNumbersII();

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode output = solution.addTwoNumbers(l1, l2);
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // push all elements of l1 and l2 into stack1 and stack2, respectively
        Stack<ListNode> stack1 = new Stack<>();
        ListNode curNode1 = l1, curNode2 = l2;
        while (curNode1 != null) {
            stack1.push(curNode1);
            curNode1 = curNode1.next;
        }

        Stack<ListNode> stack2 = new Stack<>();
        while (curNode2 != null) {
            stack2.push(curNode2);
            curNode2 = curNode2.next;
        }

        // sum represents total sum in every iteration includes carry from previous iteration
        int sum = 0;
        // head represents current head of result list
        ListNode head = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // add curNode value to sum if any of two lists are not empty
            if (!stack1.isEmpty()) {
                sum += stack1.pop().val;
            }
            if (! stack2.isEmpty()) {
                sum += stack2.pop().val;
            }

            // get curNode val
            head.val = sum % 10;
            // preprocess carry value for next new head: newHead -> head -> ...
            ListNode newHead = new ListNode(sum / 10);
            // connect with newHead with curNode
            newHead.next = head;
            // assign head to new head
            head = newHead;
            // DO NOT FORGET to assign carry for sum value, to prepare for next sum
            sum /= 10;
        }

        // if head == 0, drop the head; else, keep the head
        if (head.val == 0) {
            return head.next;
        }
        else {
            return head;
        }
    }
}
