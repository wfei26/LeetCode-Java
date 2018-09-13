import java.util.List;

public class A024_SwapNodesInPairs {
    public static void main(String[] args) {
        A024_SwapNodesInPairs solution = new A024_SwapNodesInPairs();
        int[] myInputs = {1,2,3,4,5,6};
        ListNode myList = solution.createList(myInputs);
        ListNode resultList = solution.swapPairs(myList);
        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
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

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curPtr = dummy;
        //if the size is even, we need to swap every two pairs until the end
        //if the size is odd, we leave the last node unchanged
        while (curPtr.next != null && curPtr.next.next != null) {
            ListNode leftNode = curPtr.next;
            ListNode rightNode = curPtr.next.next;
            curPtr.next = rightNode; //move rightNode to left
            leftNode.next = rightNode.next; //connect current leftNode to next leftNode (of next iteration)
            rightNode.next = leftNode; //connect current rightNode to current leftNode to complete swap step
            curPtr = curPtr.next.next; //move curPtr to next leftNode (of next iteration
        }
        return dummy.next;
    }
}
