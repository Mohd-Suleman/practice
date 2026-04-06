package leetcode150;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Maximum profile: "+buyAndSell(arr));
    }

    // https://www.youtube.com/watch?v=Q7v239y-Tik
    // If current element is > previous, then consider it as profit
    // Perform this till end
    public static int buyAndSell(int[] arr) {
        int maxProfit = 0;

        for(int i=1; i<arr.length;i++) {
            if(arr[i]>arr[i-1])
                maxProfit += arr[i] - arr[i-1];
        }
        return maxProfit;
    }
}
