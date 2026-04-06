package leetcode150;

public class JumpGameII {
    public static void main(String[] args) {
        int[] arr = {2,4,1,2,3,1,1,2};
        System.out.println("Minimum Jump(s) needed to reach destination: "+ minimumJump(arr));
    }

    // Need to re-visit, not working as expected...
    //https://www.youtube.com/watch?v=9kyHYVxL4fw
    public static int minimumJump(int[] arr) {
        int len = arr.length;
        if(len==1)
            return 0;
        int destination = len-1;
        int coverage = 0;
        int lastJump = 0;
        int maxJump = 0;

        for(int i=0; i<len; i++) {
            coverage = Math.max(coverage, i+arr[i]);

            if(i == lastJump) {
                lastJump = coverage;
                maxJump++;
            }
            if(coverage >= destination)
                return maxJump;

        }
        return maxJump;
    }
}
