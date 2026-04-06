package arrays;

public class MissingElements {
    public static void main(String[] args) {
        int arr[] = {2,5,7,8,9,12};
        findMissingElementInUnsortedUsingHashing(arr);
    }

    /** Fing missing element using below has O(n^2)
     * Find diff between 1st element ana its index arr[0]-0, here the 1st index will be always 0
     * If there is no missing element then the diff between value and its index will always be same -->  arr[i]-i == diff
     * And if any missing the then  arr[i]-i != diff will be true
     * Print missing using while loop */
    public static void findMissingElementInSortedArrayWithOn2(int arr[]) {
        int n = arr.length;
        int diff = arr[0];
        for(int i=0; i<n; i++) {
            if(arr[i]-i != diff) {
                while(diff<arr[i]-i) {
                    System.out.print(i+diff +" ");
                    diff++;
                }
            }
        }

    }

    /**Find missing element with O(n)
     * Loop from arr[0] to arr[n-1] and compare 1st value with value at index 1st, 2nd value with 2nd index and so on.....
     * If n value matches with value at index n --> i==arr[cnt] then increment cnt and move on
     * If not then print nth value*/
    public static void findMissingElementInSortedArrayOn(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for(int i=arr[0]; i<arr[n-1]; i++) {
            if (i == arr[cnt]) {
                cnt++;
            } else
                System.out.print(i + " ");
        }
    }

    /** Creating another brr[arr[n-1]+1] array with size of max element in arr and set brr[] = 0
     *Mark brr[arr[i]]==1
     * Now loop through brr and if brr[i] == 0, print i as missing
     * Note:--> Loop brr from starting element of arr which is
     * i=arr[0] till i<=arr[n-1], otherwise it will print from 0
     * Time Complexity --> O(n)
     * Space Complexity --> O(m)
     * Can be utilized for Unsorted array, find maximum number in unsorted array and create new array brr of that size
     * */

    public static void findMissingElementInUnsortedUsingHashing(int[] arr) {
        int n = arr.length;
        int[] brr = new int[arr[n-1]+1];
        System.out.println(brr.length);
        for(int i=0; i<n; i++) {
            brr[arr[i]] = 1;
        }
        for(int j=arr[0]; j<=arr[n-1]; j++)
            if(brr[j]==0)
                System.out.print(j+" ");
    }

}
