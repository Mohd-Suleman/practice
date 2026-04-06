package arrays;

public class SeparateSignedNumbers {
    public static void main(String arg[]) {
        int[] arr = {0,1,2,1,0,1,2,1,0,2,1};

        SeparateSignedNumbers separate = new SeparateSignedNumbers();
        separate.printArray(arr);
        separate.separate(arr);
    }

    public void separate(int arr[]) {
        int i=0;
        int j=arr.length-1;

        while(i<j) {
            while(arr[i]<1) i++;
            while(arr[j]>0) j--;

            if(i<j) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        printArray(arr);

        separate2(arr);

        printArray(arr);
    }

    public void separate2(int arr[]) {
        int i = 0;
        int j = arr.length-1;

        while(i<j) {
            while(arr[i]<2) i++;
            while(arr[j]>1) j--;

            if(i<j) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
    }




    public void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

}