package search.binary;
/**
    Find Pivotal index from a sorted, rotated array by last 2 positions
*/
public class PivotalElementIndex {
    public static void main(String arg[]) {
        int arr[] = {25,31,40,4,7,18,20};
        System.out.println("Pivot index is: "+getPivotal(arr));

    }

    private static int getPivotal(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while(start < end) {
            if(arr[mid] >= arr[0]) {
                start = mid + 1;

            } else {
                end = mid;
            }
            mid = (start + end) / 2;
        }
        return start;
    }
}
