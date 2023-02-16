package com.chrzanop.coding.algoexpert.stacks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MinMaxStack {


    @Test
    public void TestCase1() {
        MinMaxStack stack = new MinMaxStack();
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.pop() == 7);
        testMinMaxPeek(5, 5, 5, stack);
    }

    private void testMinMaxPeek(int min, int max, int peek, MinMaxStack stack) {
        assertTrue(stack.getMin() == min);
        assertTrue(stack.getMax() == max);
        assertTrue(stack.peek() == peek);
    }


    List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
    List<Integer> stack = new ArrayList<>();

    // O(1) time | O(1) space
    public int peek() {
        return stack.get(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public int pop() {
        minMaxStack.remove(minMaxStack.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public void push(Integer number) {
        Map<String, Integer> newMinMax = new HashMap<String, Integer>();
        newMinMax.put("min", number);
        newMinMax.put("max", number);
        if (minMaxStack.size() > 0) {
            int newMin = Math.min(getMin(), number);
            int newMax = Math.max(getMax(), number);
            newMinMax.replace("min", newMin);
            newMinMax.replace("max", newMax);
        }
        minMaxStack.add(newMinMax);
        stack.add(number);
    }

    // O(1) time | O(1) space
    public int getMin() {
        return minMaxStack.get(minMaxStack.size() - 1).get("min");
    }

    // O(1) time | O(1) space
    public int getMax() {
        return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }
}



