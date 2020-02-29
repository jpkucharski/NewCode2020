package jpk.main.main;

import jpk.main.service.Anagram;
import jpk.main.service.IsAnagramService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> listOfWords = List.of("aaab","abaa","aaba");

        System.out.println(
                isAnagram(listOfWords, new Anagram())
        );
    }

    private static boolean isAnagram(List<String> list, IsAnagramService anagramService){
        return anagramService.isAnagram(list);
    }
}
