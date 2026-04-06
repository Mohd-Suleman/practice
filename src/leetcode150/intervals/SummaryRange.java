package leetcode150.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(optimized(nums));
    }

    // Explanation: https://www.youtube.com/watch?v=wvpd_FvSNzo
    // Need to revisit
    public static List<String> optimized(int[] arr) {
        List<String> list = new ArrayList<>();
        int len = arr.length;
        if(len == 0)
            return list;
        for(int i=0; i<len; i++) {
            int start = arr[i];
            while(i+1 < len && arr[i]+1 == arr[i+1]) {
                i++;
            }
            if(start != arr[i])
                list.add(start+"->"+arr[i]);
            else
                list.add(start+"");
        }
        return list;
    }
}
