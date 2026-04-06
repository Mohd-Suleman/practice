package leetcode150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if(!map.containsKey(original)) {
                if(!map.containsValue(replacement)) {
                    map.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char c = map.get(original);
                if(c != replacement)
                    return false;
            }
        }
        return true;
    }
}
