package miscellaneous.geeksforgeeks;

public class Practice {

    public static void main(String arg[]) {
        String txt = "GeeksForGeeks";
        String pat = "ks";
        System.out.println(firstOccurrence(txt, pat));

    }

    public static int firstOccurrence(String txt, String pat) {
        int txtLength = txt.length();
        int patLength = pat.length();
        int result = -1;
        boolean flag = false;
        if(patLength  > txtLength) {
            return -1;
        }
        char[] txtArray = txt.toCharArray();
        char[] patArray = pat.toCharArray();

        int firstIndex = findFirst(pat.charAt(0), txtArray);
        if(firstIndex>=0) {
            for(int i=1, j=firstIndex+1; i<patLength; i++, j++) {
                if(patArray[i]==txtArray[j]) {
                    flag=true;
                    continue;
                }
                else {
                    flag = false;
                }
            }
        }
        if(flag)
            result = firstIndex;
        return result;
    }

    public static int findFirst(char c, char[] txtArray) {
        int index = -1;
        for(int i=0; i<txtArray.length; i++) {
            if(c==txtArray[i]){
                index = i;
                break;
            }
        }
        return index;
    }
}
