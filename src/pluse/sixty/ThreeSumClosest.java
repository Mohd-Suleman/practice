package pluse.sixty;

import java.util.*;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr = {-1,0,1, 2, -1, 4};
        int target = 15;
        System.out.println(optimized(arr, target));


    }

    public static int optimized(int[] arr, int target) {
        Arrays.sort(arr);
        int result = arr[0]+arr[1]+arr[2];
        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<arr.length-2; i++) {
            int j = i+1;
            int k =  arr.length-1;

            while(j<k) {
                int sum = arr[i]+arr[j]+arr[k];
                if(sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else
                    k--;

                int diff = target - sum;
                if(diff<minDiff) {
                    minDiff = diff;
                    result= sum;
                }

                }
            }
        return result;
    }
}
