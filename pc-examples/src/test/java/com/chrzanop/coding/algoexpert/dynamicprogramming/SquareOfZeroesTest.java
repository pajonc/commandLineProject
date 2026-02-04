package com.chrzanop.coding.algoexpert.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareOfZeroesTest {

    @Test
    public void TestCase1() {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                1, 1, 1, 0, 1, 0})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        assertTrue(SquareOfZeroes.squareOfZeroes(test));
    }


    @Test
    public void TestCase2() {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                1, 0, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                1, 1, 1, 1})));
        assertTrue(SquareOfZeroes.squareOfZeroes(test));
    }


    @Test
    public void TestCase3() {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                1, 1, 1, 0, 1, 0})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        assertTrue(SquareOfZeroes.squareOfZeroesAlgo1(test));
    }

    @Test
    public void TestCase3Enhanced() {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                1, 1, 1, 0, 1, 0})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        assertTrue(SquareOfZeroes.squareOfZeroesAlgo1Enhanced(test));
    }

    @Test
    public void TestCase4() {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                1, 1, 1, 0, 1, 0})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 1, 1, 1, 0, 1})));
        test.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {
                0, 0, 0, 0, 0, 1})));
        assertTrue(SquareOfZeroes.squareOfZeroesAlgo2(test));
    }

}