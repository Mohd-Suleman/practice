package leetcode150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String  pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(isWordPattern(pattern, s));
    }

    public static boolean isWordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(strs.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strs[i];
            if(!map.containsKey(c)) {
                if(!map.containsValue(str)) {
                    map.put(c, str);
                } else {
                    return false;
                }
            } else {
                String exitingValue = map.get(c);
                if(!exitingValue.equals(str))
                    return false;
            }
        }
        return true;

    }
}
