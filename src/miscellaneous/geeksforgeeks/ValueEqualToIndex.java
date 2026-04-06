package miscellaneous.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class ValueEqualToIndex {
    public static void main(String[] arg){
        /*int[] arr = {2,5,3,6,8,9,7};
        System.out.println(valueEqualToIndex(arr, 7));*/
//        System.out.println(sumOfSeries(46441));

//        printPattern(3); needed to be completed;

        /*String names[] = { "abc", "ab", "a" };
        System.out.println(largestNameInArray(names, 3));*/

        /*int[] palArray = {121,22,1441,453};
        for(int i=0; i<palArray.length; i++)
            System.out.println(isNumberPalindrome(palArray[i]));*/


        /*int[] palArray = {121,22,1441,232,44};
        System.out.println("Final output: "+isNumberPalindrome(palArray, palArray.length));*/

//        printNumberWithoutLoop(10);

        int[] arr = {4 ,2, 1, 5, 3};

        immediateSmaller(arr);
//        System.out.println(getSum(arr, arr.length));
    }

    static public void immediateSmaller(int[] arr) {
        int l = arr.length;
        if(l!=0) {
            for(int i=0; i<l-1; i++) {
                if(arr[i]>arr[i+1])
                    System.out.print(arr[i+1]+" ");
                else
                    System.out.print(-1+" ");
            }
            System.out.print(-1+" ");
        }
        else {
            System.out.print(-1);
        }

    }

    private static List<Integer> valueEqualToIndex(int[] arr, int n) {
        int count = 1;
        List<Integer> list = new ArrayList<>();

        for(int i : arr) {
            if(i == count)
                list.add(i);
            count++;

        }
        return list;
    }

    private static long sumOfSeries(int n){
        long sum = (long)n * ((long)(n + 1)) / 2;
        return sum;
    }

    private static void printPattern(int n) {

        /*int value = n;
        while(n>0) {

            for(int i=n; i>0; i--){
                for(int j=0; j<i; j++){
                    System.out.print(value+" ");
                }
                System.out.println();
            }
            n--;
        }*/
        int a = n;
        int v=a;

        while (a>0) {
            for (int i=a; i>0; i--) {
                for (int j=0; j<n; j++) {
                    System.out.print(i);
                }

            }
            System.out.println();
            a--;
        }




    }

    private static String largestNameInArray(String[] arr, int n){
        int maxLength = 0;
        int index =-1 ;
        int len = 0;
        for(int i=0; i<n; i++) {
            len = arr[i].length();
            if(len> maxLength) {
                maxLength = len;
                index = i;
            }

        }
        return arr[index];
    }

    private static int isNumberPalindrome(int[] arr, int n) {
        int aLen = arr.length;
        System.out.println("Array length is: "+aLen);
        if(aLen < 1) {
            return 1;

        }
        for(int j=0; j<n; j++){
            String str = arr[j]+"";
            int len = str.length();
            System.out.println("String length is: "+len);
            for(int i=0; i<len/2; i++) {
                if(str.charAt(i) != str.charAt(len-i-1))
                    return 0;
            }

        }
        return 1;
    }

    private static int isStringPalindrome(String str) {
        int len = str.length();
        System.out.println("String length is: "+len);
        if(len < 1) {
            return 0;

        }

        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1))
                return 0;
        }
        return 1;
    }

    private static void printNumberWithoutLoop(int n) {
        /*if(n <=0) {
            return;
        }
        System.out.print(n);
        printNumberWithoutLoop(n-1);
        return;*/

        if(n > 0)
        {
            printNumberWithoutLoop(n - 1);
            System.out.print(n + " ");
        }
        return;
    }

    private static long getSum(long a[], long n)
    {
        long sum = 0;
        for(int i=0; i<n; i++)
            sum = sum+a[i];
        return sum;
    }




}
