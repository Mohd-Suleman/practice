package leetcode150;

import java.util.Arrays;

public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1,2,10,10,10,2,1};
        System.out.println("Total candies required for distribution: "+candy(ratings));
    }

    // Explanation: https://www.youtube.com/watch?v=5khpLVzW7QQ
    // Time --> O(n), Space --> O(n)
    //Steps: 1. New Array with same size to store the candies required
    //2. Traverse ratings from L --> R(1 --> n-1) to compare if rating[i] > ratings[i-1] THEN candies[i] will be one more than previous one(This is called --> increasing/fwd traversal)
    //2. Traverse ratings from R --> L(n-1 --> 0) to compare if rating[j-1] > ratings[j] THEN candies[j-1] will be one more than previous one(This is called --> decreasing/bckwd traversal)
    //3. At the end, sum up all candies and return.
    public static int candy(int[] ratings) {
        int rl= ratings.length;
        if(rl == 0) {
            return 0;
        }
        int[] candies = new int[rl];
        Arrays.fill(candies, 1);

        //L --> R Traverse
        for(int j=1; j<rl; j++) {
            if(ratings[j] > ratings[j-1])
                candies[j] = candies[j-1]+1;
        }

        //R --> L Traverse
        for(int j=candies.length-1; j>0; j--) {
            if(ratings[j] < ratings[j-1])
                candies[j-1] = Math.max(candies[j-1], candies[j]+1);
        }

        int totalCandy = 0;
        for(int k: candies)
            totalCandy += k;

        return totalCandy;
    }
}
