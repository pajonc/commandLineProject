package com.chrzanop.coding.algoexpert.graphs;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YoungestCommonAncestorTest {

    public HashMap<Character, YoungestCommonAncestor.AncestralTree> getTrees() {
        HashMap<Character, YoungestCommonAncestor.AncestralTree> trees = new HashMap<Character, YoungestCommonAncestor.AncestralTree>();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            trees.put(a, new YoungestCommonAncestor.AncestralTree(a));
        }

        trees
                .get('A')
                .addAsAncestor(
                        new YoungestCommonAncestor.AncestralTree[]{
                                trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')
                        });
        return trees;
    }

    @Test
    public void TestCase1() {
        HashMap<Character, YoungestCommonAncestor.AncestralTree> trees = getTrees();
        trees.get('A').addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{trees.get('F'), trees.get('G')});

        YoungestCommonAncestor.AncestralTree yca = YoungestCommonAncestor.getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
        assertTrue(yca == trees.get('B'));
    }

}