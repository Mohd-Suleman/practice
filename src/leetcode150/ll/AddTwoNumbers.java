package leetcode150.ll;

public class AddTwoNumbers {

    /**
     * Explanation: https://www.youtube.com/watch?v=KMS0WFxrsT8
     * TC --> O(n)
     * SC --> O(n)*/
    public CustomSinglyLinkedList.Node addTwoNumbers(CustomSinglyLinkedList.Node list1, CustomSinglyLinkedList.Node list2) {
        CustomSinglyLinkedList addedList = new CustomSinglyLinkedList();
        addedList.insert(0);
        CustomSinglyLinkedList.Node ptr = addedList.head;

        int carry = 0;

        while(list1 != null || list2 != null) {
            int sum = 0 + carry;

            if(list1 != null) {
                sum += list1.value;
                list1 = list1.next;
            }
            if(list2 != null) {
                sum += list2.value;
                list2 = list2.next;
            }
            carry = sum/10;
            sum = sum%10;
            addedList.insert(sum);
        }
        if (carry == 1)
            addedList.insert(1);

        return addedList.head.next;
    }

    public static void main(String[] args) {

        CustomSinglyLinkedList list1 = new CustomSinglyLinkedList();
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.printList();

        CustomSinglyLinkedList list2 = new CustomSinglyLinkedList();
        list2.insert(9);
        list2.insert(9);
        list2.insert(9);
        list2.insert(9);

        list2.printList();

        CustomSinglyLinkedList.Node newHead = new AddTwoNumbers().addTwoNumbers(list1.head, list2.head);
        list2.printListWithHead(newHead);

    }
}
