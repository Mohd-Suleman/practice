package leetcode150.matrix;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
    }

    public static void rotate(int[][] arr) {
        int n = arr.length;

        System.out.println("Before");
        for(int a=0; a<arr.length; a++) {
            for(int b=0; b<arr.length; b++) {
                System.out.print(arr[a][b]+" ");
            }
            System.out.println();
        }

        // Fix needed in below logic
       /* for(int i=0; i<(n+1)/2; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n-1-i][j];
                arr[n-1-i][j] = arr[n-1-i][n-1-j];
                arr[n-1-i][n-1-j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;

            }
        }*/

        for(int i=0; i<(n+1)/2; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = arr[n-1-j][i];
                //Bottom left = Top Bottom right
                arr[n-1-j][i] = arr[n-1-i][n-1-j];
                //Top Bottom right = Top upper right
                arr[n-1-i][n-1-j] = arr[j][n-1-i];
                //Top upper right = start
                arr[j][n-1-i] = arr[i][j];
                //Start = Bottom left
                arr[i][j] = temp;
            }
        }

        System.out.println("After");
        for(int a=0; a<arr.length; a++) {
            for(int b=0; b<arr.length; b++) {
                System.out.print(arr[a][b]+" ");
            }
            System.out.println();
        }
    }
}
