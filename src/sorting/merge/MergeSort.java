package sorting.merge;

/**
 * Divide and conquer play,
 * Dividing an unsorted array in single elements and recursively
 * Sorting and merging them into one array.
 * Space complexity: n/2 + n/2 --> n ===> O(n)
 * Time complexity:
 *          Best case: O(nlogn)
 *          Worst case: O(n^2)
 */
public class MergeSort {

    public static void main(String... arg) {
        int[] arr={20,3,11,46,4,2};
        new MergeSort().mergeSort(arr, 0, arr.length-1);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private void mergeSort(int[] arr, int start, int end) {
        //base case check as we are using recursion.
        if(start >= end)
            return;

        int mid=(start+end)/2;


        //Sorting left part
        mergeSort(arr, start, mid);
        //Sorting right part
        mergeSort(arr, mid+1, end);

        merge(arr, start, end);
    }

    private void merge(int[] arr, int start, int end) {

        int mid=(start+end)/2;
        System.out.println("Mid value "+mid);

        //Finding lengths of sub arrays below.
        int len1 = mid-start+1;
        int len2 = end-mid;

        System.out.println("Length of subArrays "+len1+" "+len2);

        //Creating array arrays with above lengths
        int[] subArray1 = new int[len1];
        int[] subArray2 = new int[len2];
        System.out.println("Created subArrays: subArray1 and subArray2 ");

        //Copy into array
        int k = start;
        for(int i=0; i<len1; i++)
            subArray1[i] = arr[k++];

        k = mid+1;
        for(int i=0; i<len2; i++)
            subArray2[i] = arr[k++];

        System.out.println("After coping values into subArray1 : "+subArray1);
        System.out.println("After coping values into subArray2 : "+subArray2);

        //Now merge 2 sorted arrays
        int index1=0;
        int index2=0;
        k = start;

        while(index1<len1 && index2<len2) {
            if(subArray1[index1] < subArray2[index2])
                arr[k++] = subArray1[index1++];
            else
                arr[k++] = subArray2[index2++];
        }

        while(index1 < len1) {
            arr[k++] = subArray1[index1++];
        }
        while(index2<len2){
            arr[k++] = subArray2[index2++];
        }
    }
}
