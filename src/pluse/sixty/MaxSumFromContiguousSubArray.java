package pluse.sixty;

public class MaxSumFromContiguousSubArray {

    public static void main(String[] args) {
        int[] arr= {1,-3,4,6,-5,2};
        System.out.println(optimized(arr));
    }
    /**
     * Kadane's Algo
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public static int optimized(int[] arr) {
        int sum = 0;
        int maxSum = 0;
        for (int j : arr) {
            sum += j;
            maxSum = Math.max(maxSum, sum);
            sum = sum < 0 ? 0 : sum;
        }
        return maxSum;
    }
    /**
     * Brute force using two loops
     * Time Complexity -> O(n^2)
     * Space Complexity -> O(1)
     */
    public static int maxSum(int[] arr) {
        int max = arr[0];
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum = sum+arr[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}


