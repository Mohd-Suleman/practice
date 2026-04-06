package leetcode150;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Maximum water can be trapped is: "+trap(heights));
    }

    // Explanation: https://www.youtube.com/watch?v=09KF1hjWoSU
    // Below is Optimized solution with TC --> O(n) and SC --> O(n)
    //1. Draw heights to visualize this problem and that will really help to solve this
    //2. Traverse heights fron Left to Right(1-->n-1) and take Maximum height b/w current and previous, Note left[0] = height[0]
    //3. Again Traverse heights fron Right to Left(n-2 --> 0) and take max Maximum height b/w current and previous, Note right[n-1] = height[n-1]
    //4. Now at every ith position, take the Minimum b/w left, right and subtract height at ith position, do this fron 0 --> n-1 and calculate the total.
    //5. Finally return the total.
    public static int trap(int[] heights) {
        int len = heights.length;
        if(len < 3)
            return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = heights[0];
        right[len-1] = heights[len-1];

        for(int i=1; i<len; i++) {
            left[i] = Math.max(left[i-1], heights[i]);
        }
        for(int j=len-2; j>=0; j--) {
            right[j] = Math.max(right[j+1], heights[j]);
        }

        int totalWater = 0;

        for(int k=0; k<len; k++) {
            totalWater += Math.min(left[k], right[k]) - heights[k];
        }
        return totalWater;
    }


}
