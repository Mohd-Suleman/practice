package bitmanipulation;

public class SingleNumber2 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,5,3,3,2,5,9,5};

        System.out.println(optimized(arr));

    }

    //Brute Force approach will be the same as SingleNumber1
    //Frequency Map approach will be the same as SingleNumber1

    //Optimized one using bitWise
    public static int optimized(int[] arr) {
        int len = arr.length;

        int ones = 0;
        int twos = 0;

        for(int i: arr) {
            ones = (ones ^ i);
            ones &= ~twos;

            twos = (twos ^ i);
            twos &= ~ones;
        }
        return ones;
    }
}
