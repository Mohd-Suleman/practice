package pluse.sixty;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
//        System.out.println(validateUsingMap("salma", "masal"));

        System.out.println(validateUsingArraysOf26("salma", "masal"));


    }

    /** Using Hashing Array to
     * 1. Store the count of each character of 1st String
     * 2. Use 2nd String and iterate over array to decrease count of characters
     * 3. If any value in array is > 0 THEN return false ELSE ture.
     Time Complexity: O(n+m)
     Space Complexity: O(26)
     https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
     */
    public static boolean validateUsingArraysOf26(String str1, String str2) {
        int[] hashArray = new int[26];
        for(char ch1 : str1.toCharArray()) {
            int index1 = ch1 - 'a';
            System.out.println("Index: "+hashArray[index1]);
            hashArray[index1]++;
        }

        for(char ch2 : str2.toCharArray()) {
            int index2 = ch2 - 'a';
            System.out.println("Index: "+index2);
            hashArray[index2]--;
        }

        for(int index: hashArray) {
            if(index!=0) return false;

        }
        return true;

    }
    /** Using HashMap to store character and occurrence
     * 1st Iteration to store character and their occurrence --> 1st String
     * 2nd it to compare and remove character occurrence * --> 2nd String
     * 3rd Iterate over map, if any character still has occurrence > 1 , then return false, else true.
     Time Complexity: O(n+m)
     Space Complexity: O(n)
     https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
     */
    public static boolean validateUsingMap(String str1, String str2) {
        boolean flag = false;
        Map<Character, Integer> map1 = new HashMap<>();
        for(Character c : str1.toCharArray()) {
            if(map1.containsKey(c)) {
                map1.put(c, map1.get(c)+1);
            } else
                map1.put(c,1);
        }
        for(Character c : str2.toCharArray()) {
            if(map1.containsKey(c) && map1.get(c) > 0) {
                map1.put(c, map1.get(c)-1);
            } else
                return flag;
        }

        for(Map.Entry<Character, Integer> entry: map1.entrySet()) {
            if(entry.getValue() > 1)
                flag = false;
            else
                flag = true;
        }
        return flag;
    }
}

