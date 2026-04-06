package leetcode150;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3};
        System.out.println("Length after removal: "+optimized(arr));
    }

    //https://www.youtube.com/watch?v=Zh0Lzs-ObQI
    // Using slow and fast pointers
    public static int optimized(int[] arr) {
        int len = arr.length;
        if(len<3)
            return 0;
        int slow = 2;
        int fast = 2;

        while(fast < len) {
            if(arr[fast] != arr[slow-2]) {
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
