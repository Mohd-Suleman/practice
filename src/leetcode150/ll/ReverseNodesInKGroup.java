package leetcode150.ll;

import java.rmi.UnexpectedException;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        CustomSinglyLinkedList list  = new CustomSinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.printListWithHead(list.head);
        System.out.println("After reverse");
        list.printListWithHead(reverseInGroup(list.head, 3));
    }

    /**
     * Revisit to get more
     * Explanation: https://www.youtube.com/watch?v=nYHOtT1Tdns
     * TC: O(n)
     * SC: O(1)
     */
    public static CustomSinglyLinkedList.Node reverseInGroup(CustomSinglyLinkedList.Node head, int k) {
        if(head == null)
            return null;

        int c = k;
        CustomSinglyLinkedList.Node currentNode = head;
        CustomSinglyLinkedList.Node preNode = null;
        while (currentNode != null && c>0) {
            CustomSinglyLinkedList.Node nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
            c--;
        }
        if(currentNode == null && c>0) {
           currentNode = preNode;
           preNode = null;
            while (currentNode != null) {
                CustomSinglyLinkedList.Node nextNode = currentNode.next;
                currentNode.next = preNode;
                preNode = currentNode;
                currentNode = nextNode;
            }
        }
        if(c>0) {
            return preNode;
        } else {
            head.next = reverseInGroup(currentNode, k);
        }

        return preNode;
    }
}
