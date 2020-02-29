package jpk.com.main;

import jpk.com.service.Palindrome;
import jpk.com.service.PalindromeService;

public class Main {

    public static final String WORD = "aAssdssaa";

    public static void main(String[] args) {

        System.out.println(
                isPalindrome(WORD, new Palindrome())
        );
    }

    private static boolean isPalindrome(String word, PalindromeService palindromeService){
        return palindromeService.isPalindrome(word);
    }
}
