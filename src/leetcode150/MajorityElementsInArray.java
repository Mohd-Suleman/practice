package leetcode150;

import java.util.Arrays;


// Explanation: https://www.youtube.com/watch?v=wD7fs5P_MVo
public class MajorityElementsInArray {
    public static void main(String[] args) {
//        int[] arr = {2,2,1,3,1,2,2};
        int[] arr = {2,2,1,3,1,2,2,2,1,3};
        System.out.println("Major element in array: "+moreOptimized(arr));
    }
    // Time O(n log n)
    // Space O(1)
    // Utilizing the fact that majority > n/2, that mean it the majority element will always pass from mid.
    public static int optimized(int[] arr) {
        int n = arr.length;
        if(n < 1)
            return 0;
        int mid = (n-1)/2;
        Arrays.sort(arr);
        return arr[mid];
    }

    // Using Frequency Map
    // Time --> O(n)
    // Space --> O(n)


    // Moore's algo
    // Condition: Major element# always > n/2
    // Time --> O(n)
    // Space --> O(1)
    public static int moreOptimized(int[] arr) {
        int majority = arr[0];
        int vote = 1;

        for(int i=1; i<arr.length; i++) {

            if(vote == 0) {
                vote++;
                majority = arr[i];
            } else if(arr[i] == majority) {
                vote++;
            } else
                vote--;
        }
        return majority;
    }

}
