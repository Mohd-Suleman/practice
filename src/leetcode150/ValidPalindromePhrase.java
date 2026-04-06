package leetcode150;

public class ValidPalindromePhrase {
    public static void main(String[] args) {
        String str = "race a-car";
        System.out.println("Is Palindrome Phrase: "+optimized(str));
    }
    public static boolean optimized(String str) {
        int len = str.length();
        //Base case
        int i = 0;
        int j = len-1;

        while(i<j) {
            char s = str.charAt(i);
            char e = str.charAt(j);

            if(s < 97 || s > 122){
                i++;
                continue;
            }
            if (e < 97 || e > 122) {
                j--;
                continue;
            }
            if(s - 'a' != e - 'a')
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}
