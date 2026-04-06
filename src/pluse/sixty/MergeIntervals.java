package pluse.sixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}};
        System.out.println(Arrays.deepToString(optimized(intervals)));;

    }

    /**
     * Explanation: https://www.youtube.com/watch?v=dzNIPX7HY6A
     * Need a DS to store multiple non-overlapping intervals.
     * If you can sort all intervals based on starting value, it will help you to plot on pen and paper so that condition/logic can be build
     * Iterate through intervals, and compare if previous-end value is < current-start value THEN merge else add to list and assign into temp
     * Note temp[] = intervals[0];
     * return list
     */
    //[[0, 9], [10, 11], [12, 20]]
    public static int[][] optimized(int[][] intervals){
        // Base case
        if(intervals.length<2)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> list = new ArrayList<>();
        int[] newInterval = intervals[0];
        list.add(newInterval);

        for(int[] interval : intervals) {
            if(newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                list.add(newInterval);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
