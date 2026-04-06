package pluse.sixty;


public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,-5,0,6,-1,4};
        System.out.println(optimized(arr));
    }

    //Similar to Kadane's Algo, take maximum from left, right and max
    //1.Take 3 variables --> leftProduct, rightProduct and maxProduct
    //2. Iterate over array and multiple leftProduct from left --> right and
    //   rightProduct from right --> left until end;
    //3. Take max among maxProduct, left and right product and this will be your answer.
    // Note if any element is 0 then replace left and right variable with 1 accordingly.
    public static int optimized(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        int leftProduct = 1;
        int rightProduct = 1;
        int n = arr.length;

        for(int i=0; i<n; i++) {

            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= arr[i];
            rightProduct *= arr[n-1-i];

            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }
}
