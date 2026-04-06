package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber1 {
    public static void main(String[] args) {
        int[] arr = {5,3,6,2,13,5,2,6,3};
//        int[] arr = {5,5,3};
        System.out.println(bruteForce(arr));

    }

    //Using XOR(Bitwise Operation)
    public int optimized(int[] arr) {
        int ans = 0;
        for(int i : arr)
            ans = ans ^ i;
        return ans;
    }



    //Using Frequency Map
    // O(n), O(n)
    public static int usingFrequencyMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int a: arr) {
            if(map.containsKey(a))
                map.put(a, map.get(a)+1);
            else
                map.put(a, 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return 0;
    }

    // picking one element and scanning into entire array
    //then again picking one element and scanning into entire array....
    // O(n*n), O
    public static int bruteForce(int[] arr) {
        int n = arr.length;

        // Iterate over every element
        for (int i = 0; i < n; i++) {

            // Initialize count to 0
            int count = 0;

            for (int j = 0; j < n; j++) {

                // Count the frequency of the element
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            // If the frequency of the element is one
            if (count == 1) {
                return arr[i];
            }
        }

        // If no element exists at most once
        return -1;
    }

}
