package com.chrzanop.coding.algoexpert.arrays.utils;

import org.junit.jupiter.api.Test;

import static com.chrzanop.coding.algoexpert.arrays.utils.GreatestCommonDivisor.gcd;
import static com.chrzanop.coding.algoexpert.arrays.utils.GreatestCommonDivisor.gcdEuclides;
import static org.junit.jupiter.api.Assertions.*;

class GreatestCommonDivisorTest {

    @Test
    void shouldTestGcd() {

        int gcd = gcdEuclides(282, 78);
        System.out.println(gcd);
        System.out.println(gcd(282,78));
    }

}