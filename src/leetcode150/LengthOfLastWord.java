package leetcode150;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = "fly me   to   the moon ";
        System.out.println("Length of last word is: "+optimized(str));
    }

    //Explanation: https://www.youtube.com/watch?v=0vlc5ttPftY
    //TC O(n), SC: O(1)
    // Start iterating from last of given String
    // Increase counter only when there is a char found
    // return count variable if its value is > 0
    public static int optimized(String word) {
        int count = 0;

        for(int i= word.length()-1; i>=0; i--) {
            if(word.charAt(i) != ' ') {
                count++;
            }
            else
                if(count > 0)
                    return count;
        }
        return count;
    }

    public static int bruteForce(String word) {
        String[] strArray = word.split(" ");
        String str = strArray[strArray.length - 1];
        return str.length();



    }
}
