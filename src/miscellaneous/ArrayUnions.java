package miscellaneous;

public class ArrayUnions {
    public static void main(String arg[]) {

        ArrayUnions arrayUnions = new ArrayUnions();

        int[] arrB = {1, 2, 1, 1, 2};
        int[] arrA = {2, 2, 1, 2, 1};

        arrayUnions.union(arrA, arrB);

    }

    public void union(int arrA[], int arrB[]) {
        int al = arrA.length;
        int bl = arrB.length;

        int[] arrC = new int[al+bl];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<al && j<bl) {
            if (arrA[i] < arrB[j]){
                arrC[k++] = arrA[i++];
            } else if(arrB[j] == arrA[i]) {
                arrC[k++] = arrA[i++];
                j++;
            } else {
                arrC[k++] = arrB[j++];
            }
        }
        while(i<al) {
            arrC[k++] = arrA[i++];
        }
        while(j<bl) {
            arrC[k++] = arrB[j++];
        }
        for(int h=0; h<arrC.length; h++)
            if(arrC[h]!=0)
                System.out.print(arrC[h]+" ");
        System.out.println("");
        System.out.println(k);
    }

}
