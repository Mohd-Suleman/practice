package pluse.sixty;

import java.util.*;

public class GroupAnagrams {

    public static void main(String... str) {
        String[] strings = {"tea", "ate", "sa","man","amn", "bat", "tab"};
//        System.out.println(bruteForce(strings));
        new GroupAnagrams().optimized(strings);
    }

    /** Time complexity --> O(n*k)
     *  Space complexity --> O(n)
     *  Youtube; https://www.youtube.com/watch?v=C9V66KyZCP8*/
    public void optimized(String[] originalArray) {
        if(originalArray.length<=1)
            return;
        Map<String, List<String>> map = new HashMap<>();

        for(String str: originalArray) {
            String occurrnceString = occurrenceRepresent(str);
            if(map.containsKey(occurrnceString)) {
                List<String> tempList = map.get(occurrnceString);
                tempList.add(str);
                map.put(occurrnceString, map.get(occurrnceString));
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(occurrnceString, list);
            }

        }
        for(Map.Entry<String, List<String>> listEntry: map.entrySet())
            System.out.print(listEntry.getValue()+" ");

    }

    public String occurrenceRepresent(String str) {
        if(str.length()<=1)
            return str;
        int[] arr = new int[26];

        for(char c : str.toCharArray()) {
            int index = c -'a';
            arr[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            if(arr[i]>0) {
                char tc = (char)(97+i);
                sb.append(tc).append(arr[i]);
            }
        }
        return sb.toString();
    }

    // TC --> O(n*n log )
    //SC --> O(n)
    //1. Sort each element fron the array so that I can be concerted to all origin chars --> tea, ate, ear --- > aet
    //2. Sort next element and check in map, if present THEN add in its value ELSE add new entry.
    public static List<List<String>> bruteForce(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
           char[] chaArray = str.toCharArray();
           Arrays.sort(chaArray);
           String sortedString = new String(chaArray);
           List<String> list = new ArrayList<>();
           list.add(str);
           if(map.containsKey(sortedString)) {
               List<String> tempList = map.get(sortedString);
               tempList.add(str);

               map.put(sortedString, tempList);
           } else
               map.put(sortedString, list);
        }
        List<List<String>> lists = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            lists.add(entry.getValue());
        }
        return lists;
    }
}
