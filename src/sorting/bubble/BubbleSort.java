package sorting.bubble;

/**
 * In every ith iteration, the largest ith element will be place to its right place.
 * Space complexity: O(1) -> Constant
 *     Time Complexity:
 *             Worst case: O(n^2)
 *             Best case: O(n)
 *     Stable or Adaptable ?
 */
public class BubbleSort {
    public static void main(String... arg) {
        int[] arr = {9,2,7,6,3,8,0};
        sort(arr);


    }



    private static int[] sort(int... arr) {
        boolean flag = false;
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int temp;
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }

            }
            if(!flag)// This is for optimization, break if no swapping happened mean array already sorted.
                break;
        }
        for(int i=0; i<n; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr;

    }
}
