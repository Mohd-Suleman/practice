package leetcode150.ll;

public class CopyListWithRandomPointer {

    //Explanation: https://www.youtube.com/watch?v=_GBo_CgST1M
    public CustomSinglyLinkedList.Node copy(CustomSinglyLinkedList.Node head) {
        if(head == null)
            return null;
        CustomSinglyLinkedList.Node currentNode = head;
        // Creating new Nodes and inserting in between
        while(currentNode != null) {
            CustomSinglyLinkedList.Node newCurrentNode = currentNode;
            newCurrentNode.next = currentNode.next;
            currentNode.next = newCurrentNode;
            currentNode = newCurrentNode.next;
        }

        currentNode = head;

        //Copy random pointer
        /*while(currentNode != null) {
            if(currentNode.randome != null) {
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }*/

        // Separating OLD and NEW lists
        currentNode = head;
        CustomSinglyLinkedList.Node newHead = head.next;
        CustomSinglyLinkedList.Node newCurrentNode = newHead.next;

        while(currentNode != null) {
            currentNode.next = newCurrentNode.next;
            currentNode = currentNode.next;
            if(currentNode != null) {
                newCurrentNode.next = currentNode.next;
                newCurrentNode = newCurrentNode.next;
            }
        }
        return newHead; // return head of new list
    }
}
