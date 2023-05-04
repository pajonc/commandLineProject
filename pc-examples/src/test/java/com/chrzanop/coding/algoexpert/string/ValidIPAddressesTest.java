package com.chrzanop.coding.algoexpert.string;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidIPAddressesTest {

    @Test
    public void TestCase1() {
        String input = "1921680";
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("1.9.216.80");
        expected.add("1.92.16.80");
        expected.add("1.92.168.0");
        expected.add("19.2.16.80");
        expected.add("19.2.168.0");
        expected.add("19.21.6.80");
        expected.add("19.21.68.0");
        expected.add("19.216.8.0");
        expected.add("192.1.6.80");
        expected.add("192.1.68.0");
        expected.add("192.16.8.0");
        ArrayList<String> actual = new ValidIPAddresses().validIPAddresses(input);
        assertTrue(expected.equals(actual));
    }

}