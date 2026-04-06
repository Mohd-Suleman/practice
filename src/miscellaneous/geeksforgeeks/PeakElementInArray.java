package miscellaneous.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class PeakElementInArray {
    public static void main(String arg[]) {

        PeakElementInArray peak = new PeakElementInArray();
        int[] arr = {-1};
        System.out.println(peak.peakElement(arr));
    }

    public int peakElement(int[] arr) {
        int l = arr.length;
        int index = -1;
        if(l>1) {
            if(arr[0]>arr[1]){
                return 0;
            }
            if(arr[l-1]>arr[l-2])
                return l-1;
            for(int i=1; i<arr.length-1; i++) {
                if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                    index = i;
                }
            }
        } else
            return 0;

        return index;
    }
}
