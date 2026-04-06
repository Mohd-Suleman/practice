package search.binary;

public class NumberOfOccurrence {
    public static void main(String arg[]) {
        int first = firstOccurrence(new int[]{0,1,2,3,4,4,4,4,4,4,5,6,7,8,9}, 8);
        int last = lastOccurrence(new int[]{0,1,2,3,4,4,4,4,4,4,5,6,7,8,9}, 8);
        int total = (last - first) + 1;
        System.out.println("Total occurrence: "+total);

    }

    private static int firstOccurrence(int arr[], int key) {
        int size = arr.length;
        int start = 0;
        int end = size - 1;
        int mid = (start + end) / 2;
        int first = -1;

        while(start <= end) {
            if(key == arr[mid]) {
                first = mid;
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }


        return first;
    }

    private static int lastOccurrence(int arr[], int key) {
        int size = arr.length;
        int start = 0;
        int end = size - 1;
        int mid = (start + end) / 2;
        int last = -1;

        while(start <= end) {
            if (key == arr[mid]) {
                last = mid;
                start = mid + 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else
                end = mid - 1;
            mid = (start + end) / 2;
        }
        return last;
    }
}
