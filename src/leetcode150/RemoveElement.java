package leetcode150;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int value = 3;
        System.out.println("After removal: "+bruteForce(arr, value));
    }


    // Iterate from 0 --> n-1
    // If val = a[i],m means given value matched with current index value
    // Then Swap it with last index value and decrease array size by 1;
    // At the end you will have array with elements not matching with give value
    // Return value of n which keeps track of size of current array
    public static int bruteForce(int[] arr, int val) {
        int i = 0;
        int n = arr.length;

        while(i<n) {
            if(arr[i] == val) {
                arr[i] = arr[n - 1];
                n--;
            } else
                i++;
        }
        return n;
    }
}
