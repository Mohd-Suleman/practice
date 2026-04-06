package pluse.sixty;

public class ClimbingStairs {
    public static void main(String[] arg) {
        int stairs = 6;
        System.out.println(optimized(stairs));
    }
    public static int optimized(int n) {
        if(n == 0) {
            return 0;
        } if(n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
