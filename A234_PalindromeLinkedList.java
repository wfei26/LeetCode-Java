import java.util.LinkedList;

public class A234_PalindromeLinkedList {
    public static void main(String[] args) {
        A234_PalindromeLinkedList solution = new A234_PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean output = solution.isPalindrome(head);
        System.out.println(output);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // find middle point of linked list by using slow and fast pointer
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of linked list
        ListNode reversedHead = reverseList(slow);
        ListNode originalHead = head;

        // iteratively compare the first half and second half
        while (reversedHead != null) {
            if (originalHead.val != reversedHead.val) {
                return false;
            }
            originalHead = originalHead.next;
            reversedHead = reversedHead.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode curNode) {
        ListNode newHead = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = newHead;
            newHead = curNode;
            curNode = nextNode;
        }
        return newHead;
    }
}

