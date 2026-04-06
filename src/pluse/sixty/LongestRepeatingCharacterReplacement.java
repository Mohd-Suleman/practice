package pluse.sixty;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "AABDAACC";
        int k = 3;
        System.out.println(usingSlidingWindow(str, k));
    }


    //Need to visit tutorial once more to dry run
    // https://www.youtube.com/watch?v=ExY8svHF_Eo
    public static int usingSlidingWindow(String str, int k) {
        int[] freq = new int[26];
        int maxFrequency = 0;
        int maxWindowLength = 0;
        int left = 0;

        for(int right = 0; right<str.length(); right++) {
            freq[str.charAt(right)-'A']++;

            maxFrequency = Math.max(maxFrequency, freq[str.charAt(right)-'A']);

            int windowLength = right - left + 1;

            if(windowLength - maxFrequency > k) {
                freq[str.charAt(left) - 'A']--;
                left++;
            }
            windowLength = right - left + 1;

            maxWindowLength = Math.max(windowLength, maxWindowLength);


        }
        return maxWindowLength;
    }
}
