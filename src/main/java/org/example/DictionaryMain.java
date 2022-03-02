package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

class Dictionary extends HashMap<String, String> {
    int countCaracthers() {
        return super.values().stream().mapToInt(String::length).sum();
    }

    int countWords() {
        return super.values().stream().mapToInt(s -> s.split(" ").length).sum();
    }

    int countMatchesCharacter(char c) {
        return StringUtils.countMatches(String.join("", super.values()), c);
    }

    String[] findWordInDefinitions(String word) {
        return (String[]) super.values().stream().filter(s -> s.contains(word)).toArray();
    }


    String getWordWithLongestDefinitionWithFor() {
        var keys = super.keySet();

        if (keys.isEmpty()) {
            return null;
        }

        String wordWithLongestDefintinition = "";

        for (var word : keys) {
            if (!super.containsKey(wordWithLongestDefintinition)) {
                wordWithLongestDefintinition = word;
            }

            if (super.get(wordWithLongestDefintinition).length() < super.get(word).length()) {
                wordWithLongestDefintinition = word;
            }
        }

        return wordWithLongestDefintinition;
    }

    Optional<String> maxByDefinition(Function<String, Integer> fn) {
        return super.entrySet().stream()
                .max(Comparator.comparing(e -> fn.apply(e.getValue())))
                .map(Entry::getKey);
    }

    Optional<String> getWordWithLongestDefinition() {
        return maxByDefinition(String::length);
    }

    Optional<String> getWordWithShortestDefinition() {
        return maxByDefinition(d -> -d.length());
    }
}

public class DictionaryMain {
    public static void main(String[] args) {


    }
}