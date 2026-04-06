package sorting.quick;

public class QuickSort {

    public static void main(String arg[]) {
        int[] arr= {3,1,5,2,4,99,6,77,55};
        new QuickSort().quickSort(arr, 0, 8);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

    }


    private void quickSort(int[] arr, int start, int end) {
        //base case
        if(start >= end)
            return;

        int pivot = partition(arr, start, end);

        //sorting left part
        quickSort(arr, start, pivot -1);

        //sorting right part
        quickSort(arr, pivot+1, end);


    }

    //Finding pivot element
    int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int count = 0;

        for(int i=start+1; i<=end; i++) {
            if(arr[i]<pivot)
                count++;
        }

        int pivotIndex = start+count;
        // swap the start index with pivot index
        int temp = arr[start];
        arr[start] = arr[pivotIndex];
        arr[pivotIndex]=temp;

        int i = start;
        int j = end;

        while(i<pivotIndex && j>pivotIndex) {

            while(arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }

            if(i < pivotIndex && j > pivotIndex) {
                //Swap i with j and increament/decreament i/j
                int temp2= arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;

                i++;
                j--;
            }
        }
        return pivotIndex;

    }

    private void swap(int a, int b) {
        int temp = a;
        a =  b;
        b = temp;
    }
}
