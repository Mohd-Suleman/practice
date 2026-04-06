package ds.linkedlist;

public class RemoveDuplicateElements {
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
        RemoveDuplicateElements list = new RemoveDuplicateElements();
        list.insert(10);
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(40);
        list.insert(50);
        list.insert(60);

        list.printList();
        list.removeDuplicate();
        list.printList();
    }

    /**
     * As list is sorted, comparing current value with its next
     * Using currentNode.value == currentNode.next.value;
     * If yes then currentNode.next = currentNode.next.next;
     */
    public void removeDuplicate() {
        Node currNode = head;
        while(currNode.next != null) {
            if(currNode.value == currNode.next.value) {
                System.out.println("Duplicate is: "+currNode.next.value);
                currNode.next = currNode.next.next;
            }
            currNode = currNode.next;
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
