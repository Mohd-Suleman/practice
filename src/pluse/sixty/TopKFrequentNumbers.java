package pluse.sixty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentNumbers {

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,2,3,1,3,4};
        optimized(arr, 3);
    }
    /**
     * Tutorial: https://www.youtube.com/watch?v=EBNPu0GgM64
     * Time Complexity O(n), Space Complexity O(n)
     * 1. Create Map that will store occurrence/frequency of numbers
     * 2. Create a Buck(Array of List) with same length as original array
     * 3. Iterate over map and put into list, Index will be frequency and value will be numbers*/
    public static void optimized(int[] arr, int k) {
        //1. Create Map that will store occurrence/frequency of numbers
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }

        //2. Create a Buck(Array of List) with same length as original array
        List<Integer>[] lists = new List[arr.length+1];
        for(int key: map.keySet()) {
            int frequency = map.get(key);
            //3. Iterate over map and put into list, Index will be frequency and value will be numbers
            if(lists[frequency] == null)
                lists[frequency] = new ArrayList<>();
            lists[frequency].add(key);
        }

        int[] result = new int[k];
        int count = 0;

        //3. Iterate over list to find Kth frequent elements, add them into array
        for(int j = lists.length-1; j>=0 && count<k; j--) {
            if(lists[j] != null) {
                for(int i: lists[j]) {
                    result[count++] = i;
                    System.out.print(i+" ");
                }
            }
        }
    }
}
