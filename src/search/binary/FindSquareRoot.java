package search.binary;

public class FindSquareRoot {
    public static void main(String arg[]) {
        int number = 65;
        int tempSol = squareRootInteger(number);
        System.out.println(exactRoot(number, 3, tempSol));
    }

    private static double exactRoot(int n, int precision, int intRoot) {
        double factor = 1;
        double ans = intRoot;

        for(int i = 0; i<precision; i++) {
            factor = factor / 10;
            for(double j = ans; j*j < n; j = j + factor) {
                ans = j;
            }
        }
        return ans;
    }


    private static int squareRootInteger(int n) {
        int start = 0;
        int end = n;
        int mid = (start + end) / 2;
        int ans = -1;

        while(start <= end) {
            int sq = mid * mid; // sq root is valid till integer range other wise your long
            if(sq == n)
                return mid;
            if(sq < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return ans;
    }
}
