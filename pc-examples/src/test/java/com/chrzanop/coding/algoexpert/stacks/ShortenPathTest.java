package com.chrzanop.coding.algoexpert.stacks;

import org.junit.jupiter.api.Test;

import static com.chrzanop.coding.algoexpert.stacks.ShortenPath.shortenPath;
import static com.chrzanop.coding.algoexpert.stacks.ShortenPath.shortenPathAlgo;
import static org.junit.jupiter.api.Assertions.*;

class ShortenPathTest {

    @Test
    public void TestCase1() {
        var expected = "/foo/bar/baz";
        var actual = shortenPath("/foo/../test/../test/../foo//bar/./baz");
        var actual2 = shortenPathAlgo("/foo/../test/../test/../foo//bar/./baz");
        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

    @Test
    public void TestCase2() {
        var expected = "../../foo/bar/baz";
        var actual = shortenPath("../../foo/bar/baz");
        var actual2 = shortenPathAlgo("../../foo/bar/baz");
        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

    @Test
    public void TestCase3() {
        var expected = "../../../bar/baz";
        var actual = shortenPath("../../foo/../../bar/baz");
        var actual2 = shortenPathAlgo("../../foo/../../bar/baz");
        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

    @Test
    public void TestCase4() {
        var expected = "/foo/bar/baz";
        var actual = shortenPath("/../../foo/bar/baz");
        var actual2 = shortenPathAlgo("/../../foo/bar/baz");
        assertEquals(expected, actual);
        assertEquals(expected, actual2);
    }

}