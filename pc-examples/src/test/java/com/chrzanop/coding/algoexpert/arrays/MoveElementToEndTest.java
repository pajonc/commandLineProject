package com.chrzanop.coding.algoexpert.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MoveElementToEndTest {

    private MoveElementToEnd metd = new MoveElementToEnd();

    @Test
    public void shouldPassSolution1() {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2));
        List<Integer> output = metd.moveElementToEnd(array, toMove);
        List<Integer> outputStart = output.subList(0, 3);
        outputStart.sort(Comparator.naturalOrder());
        List<Integer> outputEnd = output.subList(3, output.size());
        assertTrue(outputStart.equals(expectedStart));
        assertTrue(outputEnd.equals(expectedEnd));
    }

    @Test
    public void shouldPassSolution2() {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2));
        List<Integer> output = metd.moveElementToEndSolution2(array, toMove);
        List<Integer> outputStart = output.subList(0, 3);
        outputStart.sort(Comparator.naturalOrder());
        List<Integer> outputEnd = output.subList(3, output.size());
        assertTrue(outputStart.equals(expectedStart));
        assertTrue(outputEnd.equals(expectedEnd));
    }

    @Test
    public void shouldPassSolution2Empty() {
        List<Integer> array = new ArrayList<Integer>();
        int toMove = 2;
        List<Integer> output = metd.moveElementToEndSolution2(array, toMove);
        assertTrue(output.isEmpty());
    }

    @Test
    public void shouldPassSolution2Case2() {
        // "array": [1, 2, 4, 5, 3],
        //  "toMove": 3
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 3));
        int toMove = 3;
        List<Integer> expectedStart = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5));
        List<Integer> expectedEnd = new ArrayList<Integer>(Arrays.asList(3));
        List<Integer> output = metd.moveElementToEndSolution2(array, toMove);
        List<Integer> outputStart = output.subList(0, 4);
        outputStart.sort(Comparator.naturalOrder());
        List<Integer> outputEnd = output.subList(4, output.size());
        assertTrue(outputStart.equals(expectedStart));
        assertTrue(outputEnd.equals(expectedEnd));


    }

    //  "array": [5, 1, 2, 5, 5, 3, 4, 6, 7, 5, 8, 9, 10, 11, 5, 5, 12],
    //  "toMove": 5

    // "array": [1, 2, 4, 5, 6],
    // "toMove": 3

    //  "array": [3, 1, 2, 4, 5],
    //  "toMove": 3

}