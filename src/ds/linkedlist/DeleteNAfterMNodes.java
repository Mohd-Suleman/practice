package ds.linkedlist;

public class DeleteNAfterMNodes {
    Node head;
    int size;
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {

        DeleteNAfterMNodes list = new DeleteNAfterMNodes();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);

        list.printList();
        list.deleteNAfterM(3,2);
        list.printList();

    }
    /**
     * Traversing list till m-1(to find immediate previous node)
     * Then deleting n nodes using loop
     */
    public void deleteNAfterM(int m, int n) {
        Node currNode = head;
        for(int i=0; i<m-1; i++) {
            currNode = currNode.next;
        }
        System.out.println("Delete: "+currNode.next.value);
        for(int i=0; i<n; i++) {
            currNode.next = currNode.next.next;
        }

    }
    public void printList() {
       Node tempNode = head;
        while(tempNode!=null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head==null) {
            head = newNode;
            size++;return;
        }
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }
}
