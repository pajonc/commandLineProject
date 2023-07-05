package com.chrzanop.coding.algoexpert.graphs;

public class YoungestCommonAncestor {

    //O(d) time | O(1) space where d is the depth of ancestral tree
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        int depthOne = getDescendantDepth(topAncestor, descendantOne);
        int depthTwo = getDescendantDepth(topAncestor, descendantTwo);

        if (depthOne > depthTwo) {
            return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
        }

    }

    private static AncestralTree backtrackAncestralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
        while (diff > 0) {
            lowerDescendant = lowerDescendant.ancestor;
            diff--;
        }

        while (lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }
        return lowerDescendant;
    }

    private static int getDescendantDepth(AncestralTree topAncestor, AncestralTree descendant) {
        int counter = 0;
        while (descendant != topAncestor) {
            descendant = descendant.ancestor;
            counter++;
        }
        return counter;
    }


    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    /*  MINE
     public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        int levelDescendantOne = countLevel(topAncestor, descendantOne);
        int levelDescendantTwo = countLevel(topAncestor, descendantTwo);

        int diff = Math.abs(levelDescendantOne-levelDescendantTwo);

        if(levelDescendantOne>levelDescendantTwo && diff > 0) {
            while(diff>0) {
                descendantOne = descendantOne.ancestor;
                diff--;
            }
        } else {
            while(diff>0) {
                descendantTwo = descendantTwo.ancestor;
                diff--;
            }
        }

        while(descendantOne!=descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }


        return descendantOne;
    }

    private static int countLevel(AncestralTree topAncestor, AncestralTree descendant) {
        int counter = 0;
        while(descendant!=topAncestor) {
            descendant = descendant.ancestor;
          counter++;
        }
        return counter;
    }

    * */

}
