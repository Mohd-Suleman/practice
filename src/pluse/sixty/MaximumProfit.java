package pluse.sixty;

public class MaximumProfit {

    public static void main(String[] args) {
        int[] arr = {1,2,15,4,5,16};
        System.out.println(maxProfit(arr));
    }

    /** Considering a[0] is the min value to buy and
     */
    public static int calculate(int[] a) {
        int min = a[0];
        int profit = 0;

        for(int i=1; i<a.length; i++) {
            int diff = a[i] - min;
            profit = Math.max(diff, profit);
            min = Math.min(min, a[i]);
        }
        return profit;
    }

    /** https://www.youtube.com/watch?v=E2-heUEnZKU
     * 1. Consider Profit --> 0 and buy at 1st Price
     * 2. Iterate array prices fron 1 --> n-1 check if current price is less the previous
     *    THEN buy at previous only, ELSE take the maximum b/w previous and current Profit.
     * 3. Return profit.
     */
    public static int maxProfit(int[] a) {
        int maxProfit = 0;
        int buyPrice = a[0];

        for(int i=1; i<a.length; i++) {
            if(a[i]<buyPrice)
                buyPrice = a[i];
        else {
            int currentProfit = a[i]-buyPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}
