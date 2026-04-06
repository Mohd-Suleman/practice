package miscellaneous.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDuplicates {
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 4};
        ArrayDuplicates duplicates = new ArrayDuplicates();
//        System.out.println(duplicates.findDuplicates(arr));

        System.out.println(duplicates.ifDuplicate(arr));
    }

    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr.length==0)
            return list;
        for(int a: arr) {
            if(!list.contains(a))
                list.add(a);
        }
        return list;
    }

    /** Finding duplicated using Slow, Fast Pointer(Floyed's algo) to find loop
     * One loop is detected, reset slow pointer to 0 and start until slow != fast
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * https://www.youtube.com/watch?v=_n5MR8IxR6c
     */
    public int usingFloydAlgo(int[] a) {
        int slow = 0;
        int fast = 0;

        do {
            slow = a[slow];
            fast = a[a[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }

    public boolean ifDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<a.length; i++) {
            if(set.contains(a[i])) {
                System.out.println("Duplicate is: "+a[i]);
                return true;
            }
            else
                set.add(a[i]);
        }
        System.out.println("No Duplicate found!!");
        return false;
    }

}
