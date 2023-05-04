package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import static com.chrzanop.coding.algoexpert.string.LongestPalindromicSubstring.*;
import static org.junit.jupiter.api.Assertions.*;

public class LongestPalindromicSubstringTest {

    @Test
    public void TestCase1() {

        assertTrue(longestPalindromicSubstring_Algo1("abaxyzzyxf").equals("xyzzyx"));
        assertTrue(longestPalindromicSubstring_Algo2("abaxyzzyxf").equals("xyzzyx"));
        assertTrue(longestPalindromicSubstring_Algo2_Mine("abaxyzzyxf").equals("xyzzyx"));
    }

}