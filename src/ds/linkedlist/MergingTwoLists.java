package ds.linkedlist;

public class MergingTwoLists {
    Node head;
    int size;
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MergingTwoLists list1 = new MergingTwoLists();
        MergingTwoLists list2 = new MergingTwoLists();

        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(40);
        list1.insert(50);
        list1.insert(60);

        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);

        list1.printList();
        list2.printList();

        System.out.println(list1.size);
        System.out.println(list2.size);

        list1.mergeAlternate(list1, list2);

//        list1.mergeList(list1, list2);
        list1.printList();
    }

    public void mergeAlternate(MergingTwoLists list1, MergingTwoLists list2) {
        Node firstHead = list1.head;
        Node secondHead  = list2.head;
        while(firstHead != null && secondHead != null) {
            System.out.println("inside loop");
            firstHead.next = secondHead;
            firstHead = firstHead.next;
            secondHead.next = firstHead;
            secondHead = secondHead.next;
        }

    }

    public void mergeList(MergingTwoLists list1, MergingTwoLists list2) {
        Node tempNode = list1.head;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = list2.head;
    }
    public void printList() {
        Node tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            size++;
            return;
        }
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }
}
