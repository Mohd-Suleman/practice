package leetcode150.ll;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        CustomSinglyLinkedList list = new CustomSinglyLinkedList();
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(2);
        list.insert(4);
        list.insert(5);
        list.insert(5);

        list.printListWithHead(list.head);

        System.out.println("After removal");
        list.printListWithHead(optimized(list.head));
    }

    public static CustomSinglyLinkedList.Node frequencyMap(CustomSinglyLinkedList.Node head) {
        CustomSinglyLinkedList.Node currentNode = head;
        Map<Integer, Integer> map = new HashMap<>();

        while (currentNode != null) {
            int nodeValue = currentNode.value;
            if(map.containsKey(nodeValue)) {
                map.put(nodeValue, map.get(nodeValue)+1);
            } else
                map.put(nodeValue, 1);
            currentNode = currentNode.next;
        }
        CustomSinglyLinkedList newList = new CustomSinglyLinkedList();
        for(Map.Entry<Integer, Integer> set: map.entrySet()) {
            if(set.getValue() == 1) {
                newList.insert(set.getKey());
            }
        }
        return newList.head;
    }

    /**
     * Explanation: https://www.youtube.com/watch?v=eFPFwwojxGU
     * TC: O(n)
     * SC: O(1)
     * */
    public static CustomSinglyLinkedList.Node optimized(CustomSinglyLinkedList.Node head) {
        CustomSinglyLinkedList.Node dummy = new CustomSinglyLinkedList.Node(0);
        dummy.next = head;

        CustomSinglyLinkedList.Node preNode = dummy;
        CustomSinglyLinkedList.Node curretnNode = head;

        while(curretnNode != null) {
            if(curretnNode.next != null && curretnNode.value == curretnNode.next.value) {
                while (curretnNode.next != null && curretnNode.value == curretnNode.next.value){
                    curretnNode = curretnNode.next;
                }
                preNode.next = curretnNode.next;
            } else {
                preNode = preNode.next;
            }

            curretnNode = curretnNode.next;
        }
        return dummy.next;
    }
}
