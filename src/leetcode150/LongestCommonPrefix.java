package leetcode150;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] words = {"flower","flow","flight"};
        System.out.println("Longest common prefix is: "+optimized(words));
    }

    //Brute Force approach
    // Pick 1st char and compare in all words, IF matches THEN move to next ELSE return the matched chars. -- O(n*n)

    //Explanation: https://www.youtube.com/watch?v=wtOQaovlvhY
    //Approach: IF you short the words then all the prefix chars will be groups
    //Now just took 1st and last words and start comparing char by char, IF matches --> append ELSE --> break
    //Finally return appended String.
    public static String optimized(String[] words) {
        if(words.length < 1)
            return "";
        StringBuilder result = new StringBuilder();
        Arrays.sort(words);

        char[] first = words[0].toCharArray();
        char[] last = words[words.length-1].toCharArray();

        for(int i=0; i<first.length; i++) {
            if(first[i] != last[i]) {
                break;
            } else
                result.append(first[i]);
        }
        return result.toString();
    }
}
