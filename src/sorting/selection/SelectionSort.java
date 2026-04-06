package sorting.selection;

/**
 * In evey ith iteration, smallest ith element is sorted or placed at right position(High level concept)
 * In this algo, we select smallest one and placing to correct place
    Selection Sorting is useful with small array: Selecting minimum from array and placing at correct position
    -> Time Complexity = O(n2)
    -> Time Complexity in best and worst case is = O(n2) {comparison is always required whether sorted or unsorted}
    -> Space Complexity = O(1), when using variable only its always O(1)/Constant
 */
public class SelectionSort {
    public static void main(String... arg) {
        int[] a = {1,6,2,3,7,55,4};
        System.out.print("Before :");
        for(int i : a)
            System.out.print(i+" ");
        System.out.println("After :");
        for(int i:selectionSort(a))
            System.out.print(i+" ");
    }

    private static int[] selectionSort(int... arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for(int j = i+1; j < n; j++) {
                int temp;
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
