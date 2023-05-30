package com.chrzanop.coding.algoexpert.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TaskAssignmentTest {

    @Test
    public void TestCase1() {
        int k = 3;
        ArrayList<Integer> tasks = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 3, 1, 4));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subarr = new ArrayList<Integer>(Arrays.asList(4, 2));
        ArrayList<Integer> subarr2 = new ArrayList<Integer>(Arrays.asList(0, 5));
        ArrayList<Integer> subarr3 = new ArrayList<Integer>(Arrays.asList(3, 1));
        expected.add(subarr);
        expected.add(subarr2);
        expected.add(subarr3);
        ArrayList<ArrayList<Integer>> actual = new TaskAssignment().taskAssignment(k, tasks);
        assertTrue(expected.equals(actual));
    }

}