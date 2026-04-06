package leetcode150.ll;

public class RotateList {
    private Node head;

    static class Node {
        private Node next;
        private int value;

        Node(int value) {
            this.next = null;
            this.value = value;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curNode = head;
        while(curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
    }

    public void printList(Node head) {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.value+" ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    /**
     * Explanation: https://www.youtube.com/watch?v=MOvpZVmJC6w
     * TC --> O(n)
     * SC --> O(1)*/
    public Node reverseListByK(Node head, int k) {
        // Handle Base case and take modulo

        Node currNode = head;
        int len = 0;
        Node tail = null;
        while(currNode != null) {
            len++;
            tail = currNode;
            currNode = currNode.next;
        }

        currNode = head;
        for(int i=1; i<len-k; i++) {
            currNode = currNode.next;
        }
        Node newTail = currNode;
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;

    }

    public static void main(String[] args) {

        RotateList list = new RotateList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.printList(list.head);
        System.out.println("After rotate: ");
        Node newHead = list.reverseListByK(list.head, 2);
        list.printList(newHead);



    }
}
