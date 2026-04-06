package leetcode150.matrix;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] spiral = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printSpiralForm(spiral);
    }

    public static void printSpiralForm(int[][] arr) {
        int startRow = 0;
        int startCol = 0;
        int endRow = arr.length-1;
        int endCol = arr[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {

            for(int i = startCol; i<= endCol; i++)
                System.out.print(arr[startRow][i]+" ");
            startRow++;

            for(int j=startRow; j<=endRow; j++ )
                System.out.print(arr[j][endCol]+" ");
            endCol--;

            if(startRow <= endRow) {
                for(int k=endCol; k>=startCol; k--)
                    System.out.print(arr[endRow][k]+" ");
            }
            endRow--;

            if(startCol <= endCol) {
                for(int l=endRow; l>=startRow; l--)
                    System.out.print(arr[l][startCol]+" ");
            }
            startCol++;
        }
    }
}
