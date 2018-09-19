import java.util.List;

public class A142_LinkedListCycleII {
    public static void main(String[] args) {
        A142_LinkedListCycleII solution = new A142_LinkedListCycleII();
        int[] myInputs = {1,2,3,4,5};
        ListNode myList = solution.createList(myInputs);
        solution.detectCycle(myList);
    }

    public ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curPtr = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            curPtr.next = newNode;
            curPtr = curPtr.next;
        }
        return dummy.next;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        //L1 is defined as the distance between the head point and entry point
        //L2 is defined as the distance between the entry point and the meeting point
        //C is defined as the length of the cycle
        //the total distance of the slow pointer traveled when encounter is L1 + L2
        //the total distance of the fast pointer traveled when encounter is L1 + L2 + n * C
        //Because the total distance the fast pointer traveled is twice as the slow pointer,
        //Thus: 2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1) C + (C - L2)*
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //after two pointers meeting, slow pointer need to travel another L1 length
                //to get the starting point of cycle
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }
}
