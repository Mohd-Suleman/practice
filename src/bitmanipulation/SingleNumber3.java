package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber3 {
    public static void main(String[] args) {
        int[] arr = {2,2,3,6,3,4,12,6};
        System.out.println(bruteForce(arr));

    }

    public static List<Integer> bruteForce(int[] arr) {
        int len = arr.length;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<len; i++) {
            int count = 0;
            for(int j=0; j<len; j++) {
                if(arr[i]==arr[j])
                    count++;
            }
            if(count==1)
                list.add(arr[i]);
        }
        return list;
    }
}
