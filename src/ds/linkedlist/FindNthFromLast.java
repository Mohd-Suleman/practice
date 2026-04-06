package ds.linkedlist;

import java.lang.module.FindException;

public class FindNthFromLast {
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
    public void insert(int value) {
        Node newNode = new Node(value);
        if(head==null) {
            head = newNode;
            size++;
            return;
        }
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        //Inserting before

        /*newNode.next = head;
        head = newNode;*/

        //Inserting at end
        last.next = newNode;
        newNode.next = null;
        size++;
    }

    public void findNthFromLast(int n) {
        int index = size-n+1;
        Node cur = head;
        for(int i=0; i<index-1; i++) {
            cur = cur.next;
        }
        System.out.println(cur.value);
    }
    public void print() {
        Node curr = head;
        while(curr!=null) {
            System.out.print(curr.value+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public int findLastIndex(int key) {
        int count=-1;
        Node curr = head;
        for(int i=0; i<size; i++) {
            if(curr.value == key) {
                count = i;
            }
            curr = curr.next;
        }
        return count;
    }

    public void deleteAtIndex(int index) {
        Node cur = head;
        for(int i=0; i<index-1; i++) {
            cur = cur.next;
        }
         cur.next = cur.next.next;
         size--;
    }
    
    public static void main(String arg[]) {
        FindNthFromLast list = new FindNthFromLast();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.insert(40);
        list.insert(80);
        list.print();
        list.findNthFromLast(7);
    }
}
