package pluse.sixty;

public class HouseRobberFirst {
    public static void main(String[] args) {
        int[] arr = {2,7,3,1,4,2,1,8};
        System.out.println(optimized(arr));
    }

    public static int optimized(int[] houses) {
        int n = houses.length;
        if(n < 2)
            return houses[0];
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-2]+houses[i], dp[i-1]);
        }
        return dp[n-1];
    }

}
