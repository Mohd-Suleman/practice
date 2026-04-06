package pluse.sixty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,2,7,9,34,11,-1};
        int k = 10;
        optimized(arr, k);
    }

    /** Optimized solution for any type of array with O(n) and O(n)*/
    public static void optimized(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int result = k - arr[i];
            if(map.containsKey(result)) {
                System.out.println("Items: "+arr[i]+" : "+result);
                System.out.println("Indexes: "+i+" : "+map.get(result));
            } else
                map.put(arr[i], i);
        }
    }

    /** Better solution for sorted array with O(n) and O(1) */
    public static void better(int[] arr, int k) {
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;

        while(i<j) {
            int sum = arr[i]+arr[j];
            if(sum==k){
                System.out.println("Items: "+arr[i]+" : "+arr[j]);
                System.out.println("Indexes: "+i+" : "+j);
                return;
            }
            else if(sum<k)
                i++;
            else
                j--;
        }
    }

    /** Time Complexity: O(n*n)*/
    public static void bruteForce1(int[] arr, int k) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]+arr[j]==k && i<j) {
                    System.out.println("Items: "+arr[i]+" : "+arr[j]);
                    System.out.println("Indexes: "+i+" : "+j);
                }
            }
        }
    }

    /** Time Complexity: O(n*n)*/
    public static void bruteForce2(int[] arr, int k) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]+arr[j]==k) {
                    System.out.println("Items: "+arr[i]+" : "+arr[j]);
                    System.out.println("Indexes: "+i+" : "+j);
                }
            }
        }

    }

}
