package leetcode150.ll;

public class MergeTwoSortedLists {

    public CustomSinglyLinkedList.Node merge(CustomSinglyLinkedList.Node head1, CustomSinglyLinkedList.Node head2) {
        CustomSinglyLinkedList finalList = new CustomSinglyLinkedList();
        CustomSinglyLinkedList.Node temp1 = head1;
        CustomSinglyLinkedList.Node temp2 =  head2;

        while(temp1 != null && temp2 != null) {
            if(temp1.value <= temp2.value) {
                finalList.insert(temp1.value);
                temp1 = temp1.next;
            } else {
                finalList.insert(temp2.value);
                temp2 = temp2.next;
            }
        }

        while(temp1 != null) {
            finalList.insert(temp1.value);
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            finalList.insert(temp2.value);
            temp2 = temp2.next;
        }

        return finalList.head;
    }

    public static void main(String[] args) {
        /*CustomSinglyLinkedList list1 = new CustomSinglyLinkedList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);
        list1.printList();

        CustomSinglyLinkedList list2 = new CustomSinglyLinkedList();
        list2.insert(4);
        list2.insert(6);
        list2.insert(7);
        list2.insert(9);
        list2.printList();*/

        CustomSinglyLinkedList list1 = new CustomSinglyLinkedList();
        list1.insert(4);
        list1.insert(6);
        list1.insert(7);
        list1.insert(9);
        list1.printList();

        CustomSinglyLinkedList list2 = new CustomSinglyLinkedList();

        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        list2.insert(5);
        list2.printList();

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        list2.printListWithHead(mergeTwoSortedLists.merge(list1.head, list2.head));
    }
}
