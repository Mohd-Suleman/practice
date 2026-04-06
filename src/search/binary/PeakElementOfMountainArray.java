package search.binary;


public class PeakElementOfMountainArray {
    public static void main(String arg[]) {
//        System.out.println(findPeakIndex(new int[]{0,3,4,5,9,12,11,7,6,2}));

        System.out.println(findPeakIndex(new int[]{3,6,8,12,10,9}));
    }

    private static int findPeakIndex(int arr[]) {
        int size = arr.length;

        int start = 0;
        int end = size - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }
}
