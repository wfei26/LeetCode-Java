import java.util.List;

public class A025_ReverseNodesInKGroup {
    public static void main(String[] args) {
        A025_ReverseNodesInKGroup solution = new A025_ReverseNodesInKGroup();
        int[] myInputs = {1,2,3,4,5,6,7,8,9,10};
        ListNode myList = solution.createList(myInputs);
        ListNode resultList = solution.reverseKGroup(myList, 4);
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curTail = dummy;
        ListNode prevNode = dummy;

        //set a infinite loop until the list does not contain any sublist
        //that length >= k
        while (true) {
            int count = k;
            while (count > 0 && curTail != null) {
                curTail = curTail.next;
                count--;
            }
            if (curTail == null) {
                break;
            }

            //reset head to the first node of current operational list
            head = prevNode.next;
            while (prevNode.next != curTail) {
                //save next insertion node
                ListNode nodeToInsert = prevNode.next;
                //connect pre head node to new head
                prevNode.next = nodeToInsert.next;
                //connect insertion node to the node after current tail
                nodeToInsert.next = curTail.next;
                //connect current tail to the insertion node
                curTail.next = nodeToInsert;
            }
            //reset prevNode and curTail to the end of current operational list
            //eg: 1->2->3->4->5->6, k=3;
            //operation 1: 3->2->1->4->5->6, set to node 1
            prevNode = head;
            curTail = head;
        }
        return dummy.next;
    }
}
