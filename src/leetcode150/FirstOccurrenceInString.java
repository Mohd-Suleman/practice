package leetcode150;

public class FirstOccurrenceInString {
    public static void main(String[] args) {
        String str1 = "sadbutsad";
        String str2 = "but";
        System.out.println(findFirstIndex(str1, str2));
    }

    //Explanation: https://www.youtube.com/watch?v=OWaZ6AosS30
    public static int findFirstIndex(String hayStack, String needle) {
        if(hayStack.length() <= needle.length())
            return -1;

        for(int i=0; i<hayStack.length()-needle.length()+1; i++) {
            if(hayStack.charAt(i) == needle.charAt(0)) {
                if(needle.equals(hayStack.substring(i,needle.length()+i)))
                    return i;
            }
        }
        return -1;
    }
}
