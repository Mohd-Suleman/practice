package miscellaneous.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    public static void main(String arg[]) {

        Solutions solutions = new Solutions();
       /* int[] arr = {2};
        System.out.println(largest(arr));
        ArrayList<Long> list = new ArrayList();
        list.add(1l);
        list.add(2l);
        list.add(3l);
        list.add(4l);
        list.add(5l);
        list.add(6l);
        list.add(7l);
        list.add(8l);
        list.add(9l);
        list.add(10l);
        list.add(9l);
        newMethod(list, 14);*/

        /*int[] arr = {3, 2, 1, 56, 10000, 167};
        int[] arr = {1, 345, 234, 21, 56789};
        solutions.getMinMax(arr);*/

        /*int[] arr = {1,2,3,4,5};
        System.out.println(searchInSorted(arr, 5, 0));*/



        System.out.println(printFibb(1));



    }

    public static long[] printFibb(int n)
    {
        long[] arr = new long[n];
        if(n>1) {
            arr[0] = 1;
            arr[1] = 1;
            for(int i=2; i<n; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
        } else {
             arr[0] = 1l;
        }

        for(long a: arr) {
            System.out.println(a);

        }
        System.out.println();
        return arr;
    }

    public static int searchInSorted(int arr[], int N, int K) {
        int start = 0;
        int end = N-1;
        int mid = end - (end+start)/2;

        while(start<=end) {
            if(arr[mid]==K) {
                return 1;
            } else if(arr[mid]>K)
                end = mid-1;
            else
                start = mid+1;

            mid = (start+end)/2;

        }
        return 0;
        // Your code here
    }

    public void getMinMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }

        }
        System.out.println(min+" "+max);
        // Code Here
    }

    public static void newMethod(ArrayList<Long> arr, int k) {
        System.out.println("Before - > "+arr);
        int length = arr.size();
        int subSet = length/k;
        int nonSubSet = length%k;
        System.out.println("Total subset "+subSet+" of "+k+" and rest elements "+nonSubSet);
        int i = 0;
        int j = k-1;
        int start = 1;
        long first, second;
        if(k<=arr.size()) {
            while(i<j && subSet>0) {
                first = arr.get(i);
                second = arr.get(j);
                arr.set(i++, second);
                arr.set(j--, first);
                if(i==j || i>j) {
                    System.out.println(start+" round is sorted");
                    i=k*start;
                    j=i+k-1;
                    subSet--;
                    start++;
                    System.out.println(i+" "+j+ " "+subSet+" "+start);
                }
            }
            j=length-1;
            while(i<j) {
                first = arr.get(i);
                second = arr.get(j);
                arr.set(i++, second);
                arr.set(j--, first);
            }
        } else {
            i=0;
            j=arr.size()-1;
            while(i<j) {
                first = arr.get(i);
                second = arr.get(j);
                arr.set(i++, second);
                arr.set(j--, first);
            }
        }
        System.out.println("After - > "+arr);
    }
    public static void reverseInGroups(ArrayList<Long> arr, int k) {
        System.out.println("Before - > "+arr);

        int i=0, j=k-1, a=k, b=arr.size()-1;
        long first, second, third, four;

        if(arr.size()==1){
            System.out.println("After - > "+arr);
            return;
        }
        if(k<=arr.size()) {
            while(i<j) {
                first = arr.get(i);
                second = arr.get(j);
                arr.set(i++, second);
                arr.set(j--, first);
            }
            while(a<b) {
                third = arr.get(a);
                four = arr.get(b);
                arr.set(a++, four);
                arr.set(b--, third);
            }
        } else {
            i=0;
            j=arr.size()-1;
            while(i<j) {
                first = arr.get(i);
                second = arr.get(j);
                arr.set(i++, second);
                arr.set(j--, first);
            }
        }

        System.out.println("After - > "+arr);
    }

    public static int largest(int[] arr) {
        int largest = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}


