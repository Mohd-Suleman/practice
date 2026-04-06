package pluse.sixty;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] arr = {8,12,15,20,-10,-7,-4,0};
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(optimized(arr));

    }

    //Apply Binary search and take fact that array is rotated.
    // Find middle element and compare if middle-element > last element, that mean you middle pointer is still at sorted part of array
    // THEN move the start pointer next to mid
    // ELSE move end pointer to middle;
    // At the end, return start element.
    public static int optimized(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            int mid  = (start + end)/2;

            if(arr[mid] > arr[end]) {
                start = mid+1;
            } else
                end = mid;
        }
        return arr[start];
    }

    public static int bruteForce(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left < right) {
           if(arr[left] > arr[right])
               left++;
           else
               right--;
        }
        return arr[left];


    }
}
