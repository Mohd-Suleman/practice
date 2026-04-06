package search.binary;

public class FirstAndLastOccurrence {
    public static void main(String arg[]) {
        int arr[] = {-2,0,1,2,3,4,5,6,6,6,6,6,6,6,6,8,9,77,88,99,888,9999};
        System.out.println("Left most: "+leftMostOccurrence(arr, 6));
        System.out.println("Right most: "+rightMost(arr, 6));
    }
    public static int leftMostOccurrence(int arr[], int key) {
        int leftMost = -1;
        int size = arr.length;
        int start = 0;
        int end = size - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (key == arr[mid]) {
                leftMost = mid;
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;

        }
        return leftMost;
    }

    public static int rightMost(int arr[], int key) {
        int rightMost = -1;
        int size = arr.length;
        int start = 0;
        int end = size - 1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(key == arr[mid]){
                rightMost = mid;
                start = mid + 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;

        }
        return rightMost;
    }
}
