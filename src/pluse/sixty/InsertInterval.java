package pluse.sixty;

public class InsertInterval {

    public static void optimized(int[][] originalInterval, int[] newInterval) {
        int[][] result = new int[originalInterval.length+1][2];
        int i = 0;
        int j = 0;

        // Add all intervals at the ends before new interval stats
        while(i<originalInterval.length && originalInterval[i][1] < newInterval[0]) {
            result[j++] = originalInterval[i++];
        }

        // Merge overlapping intervals
        while(i < originalInterval.length && originalInterval[i][0] < newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], originalInterval[i][0]);
            newInterval[1] = Math.max(newInterval[1], originalInterval[i++][1]);
        }

        result[j++] = newInterval;

        // Add remaining elements
        while(i<originalInterval.length) {
            result[j++] = originalInterval[i++];
        }
    }
}
