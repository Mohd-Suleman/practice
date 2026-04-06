package pluse.sixty;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,5,3,6,2,7};
        System.out.println(optimized(height));
    }

    /**
     Optimized approach using Tow Pointers with Time Complexity of O(n) and Space Complexity of O(1)
     https://www.youtube.com/watch?v=w7ftYsZtIbs
     1.Draw a chart to visualize the problem, chart will be very helpful to solve this problem
     2. Basic idea is to get the maximum area b/w any two heights
     3. Pick the smallest height among 2 and distance b/w them.
     4. Calculate area for current and compare with Max area so far.
     4. To select the next height(i and j), always choose the larger height.
     5. Return maximum height.
     */
    public static int optimized(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int currentArea = Math.min(height[left], height[right])* (right-left);
            maxArea = Math.max(currentArea, maxArea);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
