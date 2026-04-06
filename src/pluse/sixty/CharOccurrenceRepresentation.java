package pluse.sixty;


public class CharOccurrenceRepresentation {
    public static void main(String[] args) {
        System.out.println("Transformed Output: "+occurrenceCount("asdese"));
    }


    public static String occurrenceCount(String str) {
        if(str.isBlank()) {
            return str;
        }
        int[] arr = new int[26];
        for(char c : str.toCharArray()) {
            int index = c-'a';
            arr[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            if(arr[i]>0) {
                char ic = (char)(97+i);
                sb.append(ic).append(arr[i]);
            }
        }
        return sb.toString();
    }
}
