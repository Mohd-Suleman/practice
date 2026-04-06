package leetcode150;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,5};
        System.out.println("Number of duplicates removed: "+optimized(nums));
    }

    public static int optimized(int[] arr) {
        int n = arr.length;
        if(n < 2)
            return 0;
        int j = 0;
        for(int i=0; i<n; i++) {
            if(arr[j] != arr[i]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j+1;
    }
}
