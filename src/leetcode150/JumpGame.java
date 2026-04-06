package leetcode150;

public class JumpGame {
    public static void main(String[] args) {
//        int[] arr = {2,3,1,1,4};
        int[] arr = {3,2,1,0,4};
        System.out.println("Can reach: "+optimized(arr));
    }

    // Explanation: https://www.youtube.com/watch?v=Gtugy3mRV-A
    // if you can reach from n-2 --> n-1
    // Then decrease both(finalDest-- and currentPosition--)
    // If not then only decrease currentPosition--
    public static boolean optimized(int[] arr) {
        int len = arr.length;
        if(len < 1)
            return false;
        int finalDestination = len-1;

        for(int i=len-1; i>=0; i--) {
            if(i+arr[i] >= finalDestination)
                finalDestination = i;
        }
        return finalDestination == 0;
    }

    // Brute Force --> O(n^n)
    // DP --> O(N*N)
    // Recursion 2^n
}
