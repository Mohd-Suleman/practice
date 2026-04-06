package leetcode150.ll;

public class PartitionList {
    private Node head;

    static class Node {
        private Node next;
        private int value;

        Node(int value) {
            this.next = null;
            this.value = value;
        }

        Node() {

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
     * Explanation: https://www.youtube.com/watch?v=KT1iUciJr4g
     * TC --> O(n)
     * SC --> O(1), using only pointers*/
    public Node partitionList(Node head, int x) {
        Node currentNode = head;
        Node d1 = new Node();
        Node d2 = new Node();
        Node left = d1;
        Node right = d2;


        while(currentNode != null) {
            if(currentNode.value < x) {
                left.next = currentNode;
                left = left.next;
            } else {
                right.next = currentNode;
                right = right.next;
            }
            currentNode = currentNode.next;
        }

        left.next = d2.next;
        right.next = null;
        return d1.next;


    }

    public static void main(String[] args) {
        PartitionList list = new PartitionList();

        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(5);

        list.printList(list.head);

        Node partitioned = list.partitionList(list.head, 3);
        System.out.println("After partitioning...");
        list.printList(partitioned);
    }
}
