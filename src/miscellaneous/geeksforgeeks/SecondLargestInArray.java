package miscellaneous.geeksforgeeks;

public class SecondLargestInArray {

    public static void main(String[] arg){

        int[] a = {8,8};
        int n = a.length;
        /*System.out.println(sort(a)[n - 2]);
        for(int i: sort(a)) {
            System.out.print(i+" ");
        }*/

        System.out.println(secondLargest(a, n));
    }

    private static int[] sort(int... arr) {
        int n = arr.length;
        for(int i = 0; i< n-1; i++) {
            int temp;
            for(int j = i+1; j<n; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    private static int secondLargest(int[] arr, int n) {
        if(n < 2)
            return -1;
        int max = 0;
        int secondMax = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }

            if(max > arr[i] && arr[i] > secondMax)
                secondMax = arr[i];

        }
        if(secondMax > 0)
            return secondMax;
        else
            return -1;

    }

}

