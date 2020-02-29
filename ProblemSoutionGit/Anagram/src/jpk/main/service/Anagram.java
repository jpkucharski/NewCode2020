package jpk.main.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Anagram implements IsAnagramService {

    @Override
    public boolean isAnagram(List<String> listOfWords) {

        if(listOfWords.isEmpty()) {
            throw new IllegalArgumentException("List Is Empty or contain null!!!");
        }

        Function<String, String> stringFunction = word -> {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String modifiedString = new String(charArray);
            return modifiedString;
        };

        List<String> listOfSortedStrings = listOfWords.stream()
                .map(stringFunction)
                .collect(Collectors.toList());

        Predicate<String> stringPredicate = x-> x.equals(listOfSortedStrings.get(0));

        return listOfSortedStrings.stream().allMatch(stringPredicate);
    }





}
