package miscellaneous.geeksforgeeks;

import java.util.ArrayList;

public class SchoolsLevel {
    public static void main(String[] arg) {
        System.out.println("Hello SchoolsLevel");


//        System.out.println(armstrongNumber(153));

//        System.out.println(nextNumber(2,4,5));

//        System.out.println(isBinary("10101015"));

        /*long[] arr ={1, 2, 2, 2, 5, 7, 9};
        System.out.println(countOfElements(arr, arr.length, 2));*/

//        System.out.println(evenlyDivides(240));

//        System.out.println(reverseDigit(1230));

//        System.out.println(modify("G G G"));


//        System.out.println(getTable(5));

        /*int arr[] = {1, 2, 3, 2, 1,1};
        System.out.println(isPerfect(arr, 0));*/

//        printNumberUsingRecursion(7);


//        System.out.println(nPr(5,2));

//        int arr[] = {1, 2, 3, 1,2};
//        System.out.println(singleOnlyElementInArray(5, arr)); WIP

//        doWhileTest(5);

//        System.out.println(replaceZeroWithFive(1004)); WIP


//        int arr[] = {10, 20, 30};
//        for (float flt : streamAvg(arr, arr.length))
//            System.out.println(flt);

        /*int grid[][]={{1,0,1}, {-8,9,-2}};
        System.out.println(sumOfMatrix(3,3, grid));*/

        int a =97;
        System.out.println((char)a);

    }

    static String armstrongNumber(int n) {
        int original = n;
        String result = "";
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum = sum + temp * temp * temp;
            n = n / 10;
        }
        if (sum == original)
            result = "Yes";
        else
            result = "No";

        return result;
    }

    // nth number from Arithmetic Series, if d(a2-a1) is same then its call Arithmetic Sequence
    private static int nextNumber(int a1, int a2, int n) {
        int d = a2 - a1;
        int number = a1 + (n - 1) * d;
        return number;
    }

    private static long countOfElements(long arr[], long n, long x) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= x)
                count++;
        }
        return count;

    }

    private static boolean isBinary(String str) {
        boolean flag = true;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1')
                continue;
            else
                flag = false;
        }
        return flag;
    }

    private static int evenlyDivides(int n) {// WIP
        int count = 0;
        int original = n;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0) {
                n = n / 10;
                continue;
            }
            if (original % digit == 0)
                count++;
            n = n / 10;
        }
        return count;
    }

    void swapKth(int arr[], int n, int k) {
        int index = k - 1;
        int temp = arr[index];
        arr[arr.length - k] = temp;
    }

    private static long reverseDigit(long n) {
        long finalValue = 0;
        long sum;
        long original = n;
        int digits = 0;
        while (n > 0) {
            digits++;
            n = n / 10;
        }
        while (original > 0) {
            sum = original % 10;
            for (int i = digits - 1; i > 0; i--) {
                sum = sum * 10;
            }
            digits--;
            finalValue = finalValue + sum;
            original = original / 10;


        }
        return finalValue;
    }

    private static String modify(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int c = S.charAt(i);
            if (c == ' ')
                continue;
            else
                sb.append(S.charAt(i));
        }
        return sb.toString();
    }

    static ArrayList<Integer> getTable(int N) {
        ArrayList<Integer> table = new ArrayList<>();
        int number = 1;
        while (number <= 10) {
            table.add(number++ * N);
        }
        return table;
    }


    private static boolean isPerfect(int a[], int n) {
        int i = 0;
        int j = a.length - 1;
        while (i != j && i < j) {
            if (a[i++] == a[j--])
                continue;
            else
                return false;
        }
        return true;
    }

    private static void printNumberUsingRecursion(int n) {
        if (n < 1)
            return;
        printNumberUsingRecursion(n - 1);
        System.out.println(n);

    }

    static long nPr(long n, long r) {
        long factorialN = findFactorial(n);
        long factorialNR = findFactorial(n - r);

        return factorialN / factorialNR;
    }

    private static long findFactorial(long n) {
        long factorial = 1;
        while (n > 0) {
            factorial = factorial * n--;
        }
        return factorial;
    }

    private static int singleOnlyElementInArray(int N, int arr[]) {
        int i = 0;
        int j = i + 1;
        boolean unique = false;
        int element = 0;
        while (i < N - 1) {
            while (j < N) {
                System.out.println(i + " " + j);
                j++;
                if (arr[i] != arr[j]) {
                    unique = true;
                    element = arr[i];
                    continue;
                } else {
                    unique = false;
                    break;
                }
            }
            i++;
        }

        if (unique)
            return element;
        else
            return -1;

    }

    private static void doWhileTest(int n) {
        do {
            System.out.println("Hello : " + n);
            n++;
        } while (n < 0);
    }

    private static float[] streamAvg(int[] arr, int n) {
        float[] floatArray = new float[n];
        float sum = 0.00f;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            floatArray[i] = sum / (i + 1);
        }
        return floatArray;
    }

    String isVowel(char c){
        String vowel="aeiouAEIOU";
        return (vowel.indexOf(c)==-1) ? "NO" : "Yes";

    }

    private static int sumOfDigits(int number) {
        int sum=0;
        while (number>0) {
            sum=sum+number%10;
            number=number/10;
        }

        System.out.println("Sum of digits: "+ sum);
        return isPalindrome(sum);
    }

    /**
     Given a number N.Find if the digit sum(or sum of digits) of N is a Palindrome number or not
     The digit sum of 56 is 5+6=11.
     Since, 11 is a palindrome number.Thus,
     answer is 1.
     */
    private static int isPalindrome(int number) {
        int digits=0;
        int n=number;
        int orgNumber=number;
        int finalSum=0;

        while (n>0) {
            digits++;
            n=n/10;
        }
        System.out.println("Digit count: "+digits);
        System.out.println(number);

        int temp;
        while(number>0) {
            temp=number%10;
            int tempDigit=digits;
            while(tempDigit>1){
                temp=temp*10;
                tempDigit--;
            }
            finalSum=finalSum+temp;
            digits--;
            number=number/10;
        }
        System.out.println(finalSum+" "+orgNumber);

        if(orgNumber==finalSum)
            return 1;
        else
            return 0;

    }


}
