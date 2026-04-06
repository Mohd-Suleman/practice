package pluse.sixty;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {3,1,4,2,5};
        productArray(arr);
        System.out.println("\nOptimized approach");
        optimized(arr);

    }

    /** Time Complexity -> O(n)
     * Space Complexity -> O(n)
     * Youtube; https://www.youtube.com/watch?v=G9zKmhybKBM
     */
    public static void optimized(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];


        left[0] = 1;
//        right[n-1] = 1;
        for(int i=1; i<n; i++) {
            left[i] = left[i-1] * arr[i-1];

        }
        right[n-1] = 1;
        for(int j=n-2; j>=0; j--) {
            right[j] = right[j+1]*arr[j+1];
        }
        for(int i=0; i<n; i++) {
            result[i] = left[i] * right[i];
        }

        for(int i: result) {
            System.out.print(i+" ");
        }

    }

    /** Time Complexity -> O(n)
     * Space Complexity -> O(n)
     * Thi is not valid if product exceeds integer rage: 2^32
     * This is not valid if original array contains element value as 0, then product will be 0
     * */
    public static void productArray(int[] arr) {
        int n = arr.length;
        int product = 1;

        for(int i=0; i<n; i++)
            product *= arr[i];
        System.out.println("Total product: "+ product);
        int[] brr = new int[n];
        for(int i=0; i<n; i++) {
            int temp = product;
            brr[i] = temp/arr[i];
        }
        System.out.println("Product array: ");
        for(int i=0; i<brr.length; i++)
            System.out.print(brr[i]+" ");
    }
}
