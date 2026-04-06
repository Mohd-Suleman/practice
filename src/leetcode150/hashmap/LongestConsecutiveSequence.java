package leetcode150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {10,3,7,2,5,8,4,6,0,1};
        System.out.println("Longest Consecutive Sequence: "+optimized(nums));
    }

    public static int optimized(int[] nums) {
        int maxLen = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num: nums)  {
            map.put(num, Boolean.FALSE);
        }

        for(int num: nums) {
            int curLen = 1;
            int next = num+1;
            while(map.containsKey(next) && map.get(next) == false) {
                curLen++;
                map.put(next, true);
                next++;
            }

            int prev = num-1;
            while(map.containsKey(prev) && map.get(prev) == false) {
                curLen++;
                map.put(prev, true);
                prev--;
            }
            maxLen = Math.max(curLen, maxLen);
        }

        return maxLen;


    }
}
