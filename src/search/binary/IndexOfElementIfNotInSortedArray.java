package search.binary;

/**
 * Given a sorted array arr[] consisting of N distinct integers and an integer K, the task is to find the index of K,
   if it’s present in the array arr[]. Otherwise, find the index where K must be inserted to keep the array sorted.
 */
public class IndexOfElementIfNotInSortedArray {
    public static void main(String arg[]) {
        int arr[] = {1, 3, 5, 6, 90};
        System.out.println(findIndex(arr, 2));
    }

    public static int findIndex(int arr[], int k) {
        int size = arr.length;
        int s = 0;
        int e = size - 1;
        int mid = (s + e) / 2;
        while (s <= e) {
            if (k == arr[mid])
                return mid;
            else if (k > arr[mid])
                s = mid + 1;
            else
                e = mid - 1;
            mid = (s + e) / 2;
        }
        return e + 1;
    }
}
