package pluse.sixty;

import java.util.Arrays;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] meetings = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(optimized(meetings));
    }

    public static int optimized(int[][] meetings) {
        int n = meetings.length;
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int count = 1;
        int pre = 0;
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]); //---> (n log n)
        System.out.println(Arrays.deepToString(meetings));

        for(int i=1; i<n; i++) {
            if(meetings[i][0] > meetings[pre][1]) { // > is when start and end time are not same {1,3}{4,5}and >= when both are same {1,3}{3,5}
                count++;
                pre = i;
            }
        }
        return count;
//        return n - count; // --> This will solve removing overlapping intervals
    }

}
