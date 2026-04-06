package miscellaneous.geeksforgeeks;

/**
* This class contains various methods to find a number or string is Palindrome or not
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.usingWhileLoop(121);
    }

    /**
     * Check Palindrome using while loop
     * Time Complexity - > O(log n)
     * Space Complexity - > O(1)
     */
    public void usingWhileLoop(int number) {
        int original = number;
        int reversedNumber = 0;
        while (number > 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        String result = (original == reversedNumber) ? "Yes" : "No";
        System.out.println("Is number Palindrome: "+result);


    }

    /**
     * Check Palindrome using Recursion
     * Complexity - > O(log n)
     * Space Complexity - > O(b)
     */
    public void usingRecursion(int number, int reversedNumber) {

    }
}
