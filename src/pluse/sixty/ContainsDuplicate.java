package pluse.sixty;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,3,6};
        System.out.println(optimized(arr));
    }

    public static boolean optimized(int[] nums) {
        int len = nums.length;
        if(len < 2)
            return false;

        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num))
                return true;
            else
                set.add(num);

        }
        return false;
    }

    public static boolean bruteForce(int[] nums){
        int len = nums.length;
        if(len < 2)
            return false;
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

}



