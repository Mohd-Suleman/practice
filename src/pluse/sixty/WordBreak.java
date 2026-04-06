package pluse.sixty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String str = "catsanddog";
        List<String> list = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(optimized(str, list));

    }

    public static boolean optimized(String str, List<String> wordDict) {
        //Convert the list into set for O(1) lookup
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for(String word: wordDict) {
            maxLen = Math.max(maxLen, word.length());
            set.add(word);
        }
        boolean[] dp = new boolean[str.length()+1];
        dp[0] = true;
        int n = str.length();
        for(int i=1; i<=n; i++) {
            for(int j=i-1; j>=Math.max(0, i-maxLen); j--){
                if(dp[j] && set.contains(str.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
