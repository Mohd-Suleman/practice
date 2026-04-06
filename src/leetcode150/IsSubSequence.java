package leetcode150;

public class IsSubSequence {
    public static void main(String[] args) {
        String s = "cab";
        String t = "epnahbgdc";

        System.out.println("Is Sub Sequence: "+isSubsequence(s, t));

    }

    public static boolean isSubsequence(String sub, String original) {
        int n = original.length();
        int m = sub.length();
        boolean result = false;
        if(m>n)
            return result;
        int i=  0;
        int j = 0;
        while (i<n && j<m) {
            if(original.charAt(i) == sub.charAt(j)) {
                i++; j++;
            } else {
                i++;
            }
        }
        return (j==sub.length());

    }
}
