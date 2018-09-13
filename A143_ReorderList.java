public class A143_ReorderList {
    public static void main(String[] args) {
        A143_ReorderList solution = new A143_ReorderList();
        int[] myInputs = {1,2,3,4,5,6};
        ListNode myList = solution.createList(myInputs);
        solution.reorderList(myList);
        while (myList != null) {
            System.out.println(myList.val);
            myList = myList.next;
        }
    }

    public ListNode createList(int[] arr) {
        if (arr.length == 0) {
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

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        //find preMiddle of the list
        ListNode left = head;
        ListNode right = head;
        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }

        //reverse the right part of the list
        //eg1: 1->2->3->4->5->6  =>  1->2->3->6->5->4
        //eg2: 1->2->3->4->5     =>  1->2->3->5->4
        ListNode leftTail = left;
        ListNode rightHead = left.next;
        ListNode newRightHead = null;
        while (rightHead != null) {
            ListNode nextNode = rightHead.next;
            rightHead.next = newRightHead;
            newRightHead = rightHead;
            rightHead = nextNode;
        }

        //merge two parts of list one by one
        //eg: 1->2->3 & 6->5->4 to 1->6->2->5->3->4
        //iterations: 1->6->2 => 1->6->2->5->3 => 1->6->2->5->3->4->null
        ListNode curLeft = head;
        ListNode curRight = newRightHead;
        while (curLeft != leftTail) {
            ListNode nextRight = curRight.next;
            ListNode nextLeft = curLeft.next;
            curLeft.next = curRight;
            //The last iteration will set tail.next to null if the size of list is even
            curRight.next = nextLeft;
            curLeft = nextLeft;
            curRight = nextRight;
        }

        //if the size of list is odd, we need to set the right tail to null
        //to avoid cycling linked list
        if (curRight == null) {
            curLeft.next = null;
        }
    }
}
