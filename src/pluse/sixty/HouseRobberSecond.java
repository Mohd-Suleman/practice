package pluse.sixty;

public class HouseRobberSecond {

    public static void main(String[] args) {
        int[] arr = {9,1,2,9};
        System.out.println(optimized(arr));
    }

    public static int optimized(int[] houses) {
        int n = houses.length;
        if(n < 2) {
            return houses[0];
        }

        int[] dpSkipLastHouse = new int[n-1];
        int[] dpFirstLastHouse = new int[n-1];

        for(int i=0; i<n-1; i++) {
            dpSkipLastHouse[i] = houses[i];
            dpFirstLastHouse[i] = houses[i+1];
        }

        return Math.max(rob(dpFirstLastHouse), rob(dpSkipLastHouse));
    }

    private static int rob(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n];

        dp[0] = houses[0];
        dp[1] = Math.max(dp[0], dp[1]);

        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-2]+houses[i], dp[i-1]);
        }
        return dp[n-1];
    }

}
