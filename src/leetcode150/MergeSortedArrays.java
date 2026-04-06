package leetcode150;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {5,6,9,23};
        int[] arr2 = {14,32,56,85,400,2000};


        for(int i: optimized(arr1, arr2))
            System.out.print(i+" ");


    }


    // Pick 0th element from both the arrays and compare
    // Add smaller(i or j) to new Array[m+n] and move i or j and k also
    // Do this util end of any one of array
    // At the end, add rest elements.
    public static int[] optimized(int[] arA, int[] arB) {
        int lengthA = arA.length;
        int lengthB = arB.length;

        int[] finalArray = new int[lengthA+lengthB];
        int startA = 0;
        int startB = 0;
        int finalArrayIndex = 0;


        while(startB < lengthB && startA < lengthA) {
            if(arA[startA] < arB[startB]) {
                finalArray[finalArrayIndex++] = arA[startA++];
            } else {
                finalArray[finalArrayIndex++] = arB[startB++];
            }
        }

        while(startA < lengthA) {
            finalArray[finalArrayIndex++] = arA[startA++];
        }

        while(startB < lengthB) {
            finalArray[finalArrayIndex++] = arB[startB++];
        }
        return finalArray;
    }

}
