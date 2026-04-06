package leetcode150.ll;

public class ReverseLinkedListII {
    private Node head;
    private int size;

    public ReverseLinkedListII() {
        this.size = 0;
        this.head = null;
    }

    static class Node  {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            head.next = null;
            size++;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
    }

    public void printList() {
        Node tempNode = head;
        System.out.println("List size: "+size);
        while(tempNode != null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void printListWithHead(Node head) {
        Node tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public Node revertListInBetween(Node head, int left, int right) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node preLeft = dummy;
        Node currentNode  = head;

        for(int i=0; i<left-1; i++) {
            preLeft = preLeft.next;
            currentNode = currentNode.next;
        }
        Node subHead = currentNode;
        Node preNode = null;
        for(int j=0; j<right-left+1; j++) {
            Node nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        preLeft.next = preNode;
        subHead.next = currentNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII list = new ReverseLinkedListII();
        list.insert(4);
        list.insert(8);
        list.insert(15);
        list.insert(16);
        list.insert(23);
        list.insert(42);
        list.insert(49);

        list.printList();

        list.printListWithHead(list.revertListInBetween(list.head, 2,6));


    }


}
