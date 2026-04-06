package pluse.sixty;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] ar) {
        String str = "abcadbseos";
        System.out.println(optimized(str));
    }
    // Tutorial: https://www.youtube.com/watch?v=U2ppEzBaMck
    /**
     * Two pointer approach: Both points to 0th index
     * 1. Iterate over each char in String
     * 2. Maintain a Set to check duplicated
     * 3. While duplicate is found, removed exiting duplicate char from Set and move you left pointer to next one
     * 4. Always add char str.charAt(right) to set as duplicate has been removed already.
     * 5. Calculate the maxLength so far.....(indicates how far both pointers are, as soon as duplicate is found, then decreasing the length by increase one pointer forward)
     * 6. Return maxLength at the end.
     * TC*/
    public static int optimized(String str) {
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right<str.length(); right++) {

            while(set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, (right-left)+1);
        }
        return maxLength;
    }
}
