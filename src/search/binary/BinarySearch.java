package search.binary;

public class BinarySearch {
    public static void main(String arg[]) {
        System.out.println("Hello....");
        int arr[] = {1,3,5,6,7,8,9,10,12};
        System.out.println("At index: "+binarySearch(arr, 12));

    }

    public static int binarySearch(int arr[], int key) {
        int size = arr.length;
        System.out.println("Size: "+size);
        int sIndex = 0;
        int eIndex = size-1;
        int mid = (sIndex + eIndex)/2;
        while(sIndex <= eIndex) {
            if(key == arr[mid])
                return mid;
            if(key > arr[mid])
                sIndex = mid + 1;
            else
                eIndex = mid - 1;
            mid = (sIndex + eIndex)/2;
        }
        return -1;
    }
}
