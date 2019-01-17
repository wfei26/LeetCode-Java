import java.util.HashMap;

public class A138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        A138_CopyListWithRandomPointer solution = new A138_CopyListWithRandomPointer();
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        solution.copyRandomList(node1);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        //Use hash map to store mapping relationship between each old node and new node
        //key: curNode, value: new Node
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        //copy all the nodes with labels
        RandomListNode curNode = head;
        while (curNode != null) {
            map.put(curNode, new RandomListNode(curNode.label));
            curNode = curNode.next;
        }

        //assign next and random pointers
        curNode = head;
        while (curNode != null) {
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
            curNode = curNode.next;
        }
        return map.get(head);
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
}