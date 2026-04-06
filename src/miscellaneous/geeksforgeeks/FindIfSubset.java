package miscellaneous.geeksforgeeks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class FindIfSubset {
    public static void main(String arg[]) {

//        long a1[] = {10, 5, 2, 23, 19};
//        long a2[] = {19, 3, 23};

        int a1[] = {10, 5, 2, 23, 19};
        int a2[] = {19, 5, 23};
        FindIfSubset findIfSubset = new FindIfSubset();

        System.out.println(findIfSubset.isSubSetUsingHashSet(a1, a2));

        /*int[] arrA = {2,5,8,9,12,13,14,15,78};
        int[] arrB = {3,5,7,9,10,78};

        findIfSubset.intersection(arrA, arrB);*/

//        System.out.println(findIfSubset.isSubset(a1, a2, a2.length,a1.length));

        System.out.println("Result: "+usingTwoPointer(a1, a2));
    }

    //Using HashSet
    public boolean isSubSetUsingHashSet(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        for(int i=0; i<a.length; i++) {
            if(!set.contains(a[i]))
                set.add(a[i]);
        }
        for(int j=0; j<b.length; j++) {
            if(set.contains(b[j])) {
                flag = true;
                continue;
            }
            else
                return false;
        }
        return flag;
    }
    //Using 2 for loops which takes O(n^2) time complexity and O(1) space complexity
    public boolean isSubset(int a[], int b[]) {
        boolean flag = false;
        for(int i=0; i<b.length; i++) {
            for(int j=0; j<a.length; j++) {
                if(b[i]==a[j]) {
                    flag = true;
                    break;
                }
                else
                    flag = false;
            }
            if(!flag)
                return false;
        }
        return true;
    }
    public void intersection(int arrA[], int arrB[]) {
        int al = arrA.length;
        int bl = arrB.length;

        int[] arrC = new int[al+bl];

        int i = 0;
        int j = 0;
        int k = 0;

        //Picking only common(matching) elements
        while(i<al && j<bl) {
            if(arrB[j] == arrA[i]) {
                arrC[k++] = arrA[i++];
                j++;
            } else {
                j++;
                i++;
            }
        }
        for(int h=0; h<arrC.length; h++)
            if(arrC[h]!=0)
                System.out.print(arrC[h]+" ");
    }


    public static boolean usingTwoPointer(int a[], int b[]) {
        int al = a.length;
        int bl = b.length;

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = bl-1;

        while(i<j) {
            if(a[i]<b[j]) {
                i++;
            } else if(a[i]==b[j]) {
                i++; j++;
            } else
                return false;
        }
        return j==bl-1;

    }
}
