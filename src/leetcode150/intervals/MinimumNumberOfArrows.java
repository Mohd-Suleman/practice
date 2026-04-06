package leetcode150.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrows {

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println("Minimum balloons required: "+find(arr));
    }

    // Explanation: https://www.youtube.com/watch?v=fvBhjAp0j9c
    // If (currentEndPoint < nextStartPoint)
    public static int find(int[][] points) {
        int len = points.length;

        if(len < 1)
            return 0;

        Arrays.sort(points, Comparator.comparingInt(i -> i[0]));
        int arrow = 1;
        int currentEndPoint = points[0][1];

        for(int i=1; i<len; i++) {
            if(currentEndPoint < points[i][0]) {
                arrow++;
                currentEndPoint = points[i][1];
            }
        }
        return arrow;
    }
}
