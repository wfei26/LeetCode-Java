public class A086_PartitionList {
    public static void main(String[] args) {
        A086_PartitionList solution = new A086_PartitionList();
        int[] myInputs = {4, 5, 1, 9};
        ListNode myList = solution.createList(myInputs);
        ListNode resultList = solution.partition(myList, 3);
        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
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

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode dummyLeft = new ListNode(-1);
        ListNode dummyRight = new ListNode(-1);
        ListNode curLeft = dummyLeft, curRight = dummyRight, curPtr = head;
        while (curPtr != null) {
            //small elements put in left list
            if (curPtr.val < x) {
                curLeft.next = curPtr;
                curLeft = curLeft.next;
            }
            //greater or equal elements put in right list
            else {
                curRight.next = curPtr;
                curRight = curRight.next;
            }
            curPtr = curPtr.next;
        }
        //concat left and right list
        curLeft.next = dummyRight.next;
        //Very important!!! Set last node.next = null to avoid cycling linked list
        //Eg: 5->6->1->2, it will generate 1->2->5->6->1... without this step
        curRight.next = null;
        return dummyLeft.next;
    }
}
