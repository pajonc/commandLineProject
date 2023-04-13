package com.chrzanop.coding.algoexpert.binarysearchtrees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.chrzanop.coding.algoexpert.binarysearchtrees.SameBSTs.sameBsts;
import static org.junit.jupiter.api.Assertions.*;

public class SameBSTsTest {


    @Test
    public void TestCase1() {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        assertTrue(sameBsts(arrayOne, arrayTwo) == true);
    }

}