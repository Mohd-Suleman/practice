package pluse.sixty;

import java.util.Arrays;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] meetings = {{5,10}, {0,30}, {15,20}};
        System.out.println(canAttendAllMeetings(meetings));
    }


    public static boolean canAttendAllMeetings(int[][] meetings) {
        int n = meetings.length;

        if(n==1)
            return true;
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(meetings));
        for(int i=0; i<n-1; i++) {
            int[] meeting1 = meetings[i];
            int[] meeting2 = meetings[i+1];
            if(meeting1[1] > meeting2[0])
                return false;
        }
        return true;
    }
}
