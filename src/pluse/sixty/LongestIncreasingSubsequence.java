package pluse.sixty;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] ar = {3,4,-1,0,6,2,3,5};
        System.out.println(optimized(ar));
    }
    public static int optimized(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j]) {
                    if(dp[j]+1 > dp[i]) {
                        dp[i]+=1;
                    }
                }
            }

        }
        int sequenceLength = Integer.MIN_VALUE;

        for(int i: dp) {
            sequenceLength = Math.max(sequenceLength, i);
        }

        return sequenceLength+1;
    }

}
