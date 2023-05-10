package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.chrzanop.coding.algoexpert.string.GroupAnagrams.groupAnagrams_Algo1;
import static com.chrzanop.coding.algoexpert.string.GroupAnagrams.groupAnagrams_Algo2;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAnagramsTest {

    @Test
    public void TestCase1() {
        List<String> words =
                new ArrayList<String>(
                        Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        List<List<String>> expected = new ArrayList<List<String>>();
        expected.add(new ArrayList<String>(Arrays.asList("yo", "oy")));
        expected.add(new ArrayList<String>(Arrays.asList("flop", "olfp")));
        expected.add(new ArrayList<String>(Arrays.asList("act", "tac", "cat")));
        expected.add(new ArrayList<String>(Arrays.asList("foo")));
        List<List<String>> output1 = groupAnagrams_Algo1(words);
        List<List<String>> output2 = groupAnagrams_Algo2(words);
        for (List<String> innerList : output2) {
            Collections.sort(innerList);
        }
        for (List<String> innerList : output1) {
            Collections.sort(innerList);
        }

        assertTrue(compare(expected, output2));
        assertTrue(compare(expected, output1));
    }

    public boolean compare(List<List<String>> expected, List<List<String>> output) {
        if (expected.size() != output.size()) return false;

        for (List<String> group : expected) {
            Collections.sort(group);
            if (!output.contains(group)) return false;
        }

        return true;
    }

}