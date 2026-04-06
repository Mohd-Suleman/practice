package pluse.sixty;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1, 2, -1, 4};
        int target = 0;
        System.out.println("Brute Force "+bruteForce(arr, target));
        System.out.println();
        System.out.println("Optimized "+optimized(arr, target));
    }

    /**
     This is the extension of Two Sum problem
     Time Complexity --> O(n^2)
     Space Complexity --> O(n)
     Tutorial: https://www.youtube.com/watch?v=cRBSOz49fQk
     */
    public static List<List<Integer>> optimized(int[] arr, int target) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<n-2; i++) {
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int sum = arr[i]+arr[j]+arr[k];
                if(target == sum) {
                    set.add(Arrays.asList(i, j, k));
                    j++;
                }

                else if(sum > target)
                    k--;
                else
                    j++;
            }

        }
        return new ArrayList<>(set);
    }

    /** Time Complexity --> O(n^3)
     * Space Complexity --> O(n)
     * */
    public static List<List<Integer>> bruteForce(int[] arr, int target) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Set<List<Integer>> list = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    if(arr[i]+arr[j]+arr[k] == target) {
                        list.add(Arrays.asList(i, j, k));
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }
}
