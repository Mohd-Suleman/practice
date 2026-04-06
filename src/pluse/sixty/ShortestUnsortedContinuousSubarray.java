package pluse.sixty;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,5,4,6};
        int[] arr = {1,5,4,2,3,8};
        System.out.println("Need to sort " +optimized(arr)+" elements");
    }

    /**
     * Time Complexity of O(n)
     * Space Complexity of O(n)
     * Used 2 pointers, left and right and use below 3 steps
     * 1. Find unsorted subarray using two pointers
     * 2. Find minimum and maximum in unsorted subarray
     * 3. Fix/(move back and forward) left and right pointer based on minimum and maximum values
     * Tutorial: https://www.youtube.com/watch?v=WU_1PmJ5QrY
     */
    public static int optimized(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int result;
        int size = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //1. Find unsorted subarray using two pointers
        while(left < size && arr[left]<arr[left+1]) {
            left++;
        }
        while(right>=0 && arr[right] < arr[right-1]) {
            right--;
        }

        //2. Find minimum and maximum in unsorted subarray
        // This condition is true if array/subarray in unsorted, else false]
        // Both left and right pointers will point Unsorted bound respectively and start iteration from there
        if(left < right) {
            for(int i = left; i<right; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
        }

        //3. Fix/(move back and forward) left and right pointer based on minimum and maximum values
        while(left>=0 && arr[left] > min) {
            left--;
        }
        while(right<size && arr[right] < max) {
            right++;
        }

        result = right - left - 1;
        return result;
    }
}
