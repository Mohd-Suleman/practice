package leetcode150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] arg) {
        String ransomNote = "aa";
        String magazine = "aab";
//        System.out.println(usingMap(ransomNote, magazine));

        System.out.println(usingArray(ransomNote, magazine));
    }

    public static boolean usingArray(String ransomNote, String magazine) {
        int[] magazineArray = new int[26];

        for(char mC : magazine.toCharArray()) {
            magazineArray[mC-'a']++;
        }

        for(char rC: ransomNote.toCharArray()) {
            if(magazineArray[rC-'a'] == 0)
                return false;
            else
                magazineArray[rC-'a']--;
        }

        return true;

    }

    public static boolean usingMap(String ransomNote, String magazine) {
        int rLen = ransomNote.length();
        int mLen = magazine.length();

        Map<Character, Integer> magCharFreqMap = new HashMap<>();
        for(int i=0; i<mLen; i++) {
            char mChar = magazine.charAt(i);
            if(magCharFreqMap.containsKey(mChar))
                magCharFreqMap.put(mChar, magCharFreqMap.get(mChar)+1);
            else
                magCharFreqMap.put(mChar, 1);
        }

        for(int j=0; j<rLen; j++) {
            char rChar = ransomNote.charAt(j);
            if(magCharFreqMap.containsKey(rChar) && magCharFreqMap.get(rChar)>0) {
                magCharFreqMap.put(rChar, magCharFreqMap.get(rChar) - 1);
            }
            else
                return false;
        }
        return true;
    }
}
