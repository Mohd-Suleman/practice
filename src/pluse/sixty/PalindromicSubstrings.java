package pluse.sixty;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String str = "abbac";
        System.out.println("Number of Palindrome for String "+str+" is: "+optimized(str));
    }

    public static int optimized(String str) {
        int len = str.length();
        if(len <= 1)
            return 1;
        int count = 0;

        for(int i=0; i<len; i++) {
            //For Odd length
            count += countPalindromes(str, i, i);

            //For Even length
            count += countPalindromes(str, i, i+1);
        }
        return count;
    }

    private static int countPalindromes(String str, int center, int next) {
        int count = 0;
        while(center >= 0 && next < str.length() && str.charAt(center) == str.charAt(next)) {
            count++;
            center--;
            next++;
        }
        return count;
    }
}
