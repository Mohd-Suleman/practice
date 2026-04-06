package sorting.insertion;

/**
    In this algo, considering that 1st element is already sorted which is j (j=i-1) and start comparing with next element i(i=1)
    i is always next element, j will start with i-1 and decrease till 0, if condition is matched, values swapped.

    Space complexity: O(1) -> Constant
    Time Complexity:
            Worst case: O(n^2)
            Best case: O(n)

    Stable or Adaptable ?
 */
public class InsertionSort {
    public static void main(String[] arg) {
        int[] a = {3,5,4,8,2,1};


         for (int i : sort(a))
             System.out.print(i+" ");
    }

    private  static int[] sort(int... a) {
        for(int i = 1; i < a.length; i++) {
            int temp = a[i];
            for(int j = i-1; j>=0; j--) {
                if(a[j] > temp) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
                a[j] =  temp;
            }
        }
        return a;
    }
}
