package pluse.sixty;

import java.util.PriorityQueue;

public class KthLargestNumberWithoutSorting {

    public static void main(String[] args) {
        int[] arr = {1,5,3,6,4,8,0};
        int k = 4;
        System.out.println(usingMinHead(arr, k));
    }

    /**
     * TC: O(n log n)
     * SC: O(n)
     * Tutorial: https://www.youtube.com/shorts/my-6HncaGFQ*/
    public static int usingMinHead(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // O(n)

        for(int num: arr) {
            queue.offer(num); // O(log n)
            if(queue.size()>k) {
                queue.remove();
            }
        }
        return queue.peek();
    }
}
