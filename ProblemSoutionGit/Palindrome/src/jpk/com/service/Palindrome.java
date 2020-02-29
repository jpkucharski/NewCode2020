package jpk.com.service;

public class Palindrome implements PalindromeService {

    @Override
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        String s2 = s1.chars().collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append)
                .reverse().toString();
        return s1.equals(s2);
    }
}
