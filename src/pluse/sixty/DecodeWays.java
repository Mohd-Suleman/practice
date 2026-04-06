package pluse.sixty;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(optimized("1204"));
    }

    public static int optimized(String digits) {
        int n = digits.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = digits.charAt(0)=='0' ? 0 : 1;

        for(int i=2; i<=n; i++) {
            int oneDigit =  Integer.parseInt(digits.substring(i-1, i));
            int towDigits = Integer.parseInt(digits.substring(i-2, i));

            if(oneDigit >= 1) {
                dp[i] += dp[i-1];
            } if(towDigits >=10 && towDigits <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
