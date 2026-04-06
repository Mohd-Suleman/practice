package leetcode150;

public class RotateArrayByKElements {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 3;

        /*System.out.println("Rotating from End");
        rotateFromEnd(arr, k);*/

        System.out.println("Rotating from Start");
        rotateFromStart(arr, k);
    }

    public static void rotateFromStart(int[] arr, int k) {
        int len = arr.length;
        if (len < 2)
            return;
        k = k % len;

        for(int i=0, j=k-1; i<j; i++, j--)  {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for(int i=k, j=len-1; i<j; i++, j--)  {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for(int i=0, j=len-1; i<j; i++, j--)  {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //Printing array
        for(int num: arr) {
            System.out.print(num+" ");
        }
    }

    // Reverse in 3 Parts and Use 2 pointers
    //1. Revers last k elements from n-k-1 --> n-1
    //2. Revers first n-k elements from 0 --> n-k
    //3. Finally, Revers whole array from 0 --> n-1
    public static void rotateFromEnd(int[] arr, int k) {
        int len = arr.length;
        if(len < 2)
            return;
        k = k % len;

        for(int i=0, j=len-1-k; i<j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for(int i=len-k, j=len-1; i<j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for(int i=0, j=len-1; i<j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //Printing array
        for(int num: arr) {
            System.out.print(num+" ");
        }
    }

}
