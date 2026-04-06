package pluse.sixty;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(optimized(2,3));
    }

    public static int optimized(int n, int m) {

        if(n==0 || m==0)
            return 0;
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(i==0 || j==0)
                    arr[i][j] = 1;
                else
                    arr[i][j] = arr[i][j-1]+arr[i-1][j];
            }
        }
        return arr[n-1][m-1];
    }
}
