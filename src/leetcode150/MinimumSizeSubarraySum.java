package leetcode150;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println("Minimum size of array is: "+optimized(nums, target));
    }
    public static int optimized(int[] arr, int target) {
        int minWin = Integer.MAX_VALUE;
        int len = arr.length;

        if(len == 0)
            return minWin;

        int i = 0;
        int j = 0;

        int sum = 0;


        while(j<len) {
            sum += arr[j];
            j++;

            while(sum >= target) {
                int win = j-i;
                minWin = Math.min(minWin, win);

                sum -= arr[i];
                i++;
            }

        }

        return minWin = minWin == Integer.MAX_VALUE ? 0 : minWin;

    }
}
