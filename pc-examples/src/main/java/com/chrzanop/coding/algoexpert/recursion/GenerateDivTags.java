package com.chrzanop.coding.algoexpert.recursion;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class GenerateDivTags {

    private static final String OPENING_TAG = "<div>";
    private static final String CLOSING_TAG = "</div>";

    public static void main(String[] args) {
        GenerateDivTags generateDivTags = new GenerateDivTags();

        generateDivTags.generateDivTags(2);

    }

    @Test
    public void shouldPass() {
        int input = 3;
        ArrayList<String> expected =
                new ArrayList<String>(
                        Arrays.asList(
                                "<div><div><div></div></div></div>",
                                "<div><div></div><div></div></div>",
                                "<div><div></div></div><div></div>",
                                "<div></div><div><div></div></div>",
                                "<div></div><div></div><div></div>"));
//        ArrayList<String> actual = generateDivTagsMySolution(input);
        ArrayList<String> actual = generateDivTags(input);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }


    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> matchedDivTags = new ArrayList<>();
        generateDivTagsFromPrefix(numberOfTags, numberOfTags, "", matchedDivTags);
        return matchedDivTags;
    }


    public void generateDivTagsFromPrefix (int openingTagsNeeded, int closingTagsNeeded, String prefix, ArrayList<String> result) {
        if(openingTagsNeeded > 0) {
            String newPrefix = prefix + "<div>";
            generateDivTagsFromPrefix(openingTagsNeeded-1, closingTagsNeeded, newPrefix, result);
        }

        if(closingTagsNeeded > openingTagsNeeded) {
            String newPrefix = prefix + "</div>";
            generateDivTagsFromPrefix(openingTagsNeeded, closingTagsNeeded-1, newPrefix, result);
        }

        if(closingTagsNeeded == 0) {
            result.add(prefix);
        }
    }





    public ArrayList<String> generateDivTagsMySolution(int numberOfTags) {

        List<String> validTags = buidValidTags(numberOfTags);
        ArrayList<String> temp = new ArrayList<>();
        Set<String> result = new HashSet<>();
        generateDivTagsMySolution(validTags, temp, result, numberOfTags);

        return new ArrayList<>(result);
    }


    private boolean generateDivTagsMySolution(List<String> validTags, ArrayList<String> temp, Set<String> result, int numberOfTags) {

        if (temp.size() == validTags.size()) {
            result.add(temp.stream().collect(Collectors.joining()));
            return true;
        }

        for (int i = 0; i < validTags.size(); i++) {
            if (isValidTagToAdd(temp, validTags.get(i), numberOfTags)) {
                temp.add(validTags.get(i));
                if (generateDivTagsMySolution(validTags, temp, result, numberOfTags)) {
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return true;
    }


    private boolean isValidTagToAdd(ArrayList<String> temp, String tag, int numberOfTags) {

        int openingTags = countOpening(temp);
        int closingTags = countClosing(temp);

        if (tag.equals(OPENING_TAG) && openingTags < numberOfTags) {
            return true;
        }
        if (tag.equals(CLOSING_TAG) && closingTags < openingTags) {
            return true;
        }
        return false;
    }

    private int countOpening(ArrayList<String> temp) {
        int counter = 0;
        for (String tag : temp) {
            if (tag.equals(OPENING_TAG)) {
                counter++;
            }
        }
        return counter;
    }

    private int countClosing(ArrayList<String> temp) {
        int counter = 0;
        for (String tag : temp) {
            if (tag.equals(CLOSING_TAG)) {
                counter++;
            }
        }
        return counter;
    }


    private List<String> buidValidTags(int tagsSize) {
        List<String> validTags = new ArrayList<>();
        for (int i = 0; i < tagsSize; i++) {
            validTags.add(OPENING_TAG);
        }
        for (int i = 0; i < tagsSize; i++) {
            validTags.add(CLOSING_TAG);
        }
        return validTags;
    }


}
