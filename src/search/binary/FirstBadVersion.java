package search.binary;
/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version is
 * developed based on the previous version, all the versions after a bad version are also bad.
 * NOTE:--> Same as finding left most occurrence
 */
public class FirstBadVersion {
    public static void main(String arg[]) {
        System.out.println(badVersionIndex(new int[]{0,0,1,1,1,1,1}, 1));
    }

    private static int badVersionIndex(int arr[], int badVersion) {
        int size = arr.length;
        int start = 0;
        int end = size - 1;
        int mid = (start + end) / 2;
        int index = -1;

        while(start <= end) {
            if(badVersion == arr[mid]) {
                index = mid;
                end = mid - 1;
            }
            else if (badVersion > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
            mid = (start + end) / 2;
        }
        return index;
    }
}
