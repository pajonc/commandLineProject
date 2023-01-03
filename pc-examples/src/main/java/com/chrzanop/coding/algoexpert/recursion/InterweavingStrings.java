package com.chrzanop.coding.algoexpert.recursion;

public class InterweavingStrings {

    public static void main(String[] args) {
//        String one = "aaa";
//        String two = "aaaf";
//        String three = "aaafaaa";

        String one = "aabcc";
        String two = "dbbca";
        String three = "aadbbcbcac";

        System.out.println(interweavingStrings(one, two, three));


        String one_ = "aaaaaaa";
        String two_ = "aaaabaaa";
        String three_ = "aaaaaaaaaaaaaab";

        System.out.println(interweavingStringsMemoize(one_, two_, three_));
//
//        String one__ = "algoexpert";
//        String two__ = "your-dream-job";
//        String three__ = "your-algodream-expertjo";
//
//        System.out.println(interweavingStrings(one__, two__, three__));
//
//
//        String one___ = "aabcc";
//        String two___ = "dbbca";
//        String three___ = "aadbbbaccc";
//
//        System.out.println(interweavingStrings(one___, two___, three___));

    }


    public static boolean interweavingStrings(String one, String two, String three) {

        if (one.length() + two.length() != three.length()) {
            return false;
        }
        return areInterwoven(one, two, three, 0, 0);
    }


    private static boolean areInterwoven(String one, String two, String three, int i, int j) {

        int k = i + j;
        System.out.print("i" + i);
        System.out.println(" j" + j);
        if (k == three.length()) {
            return true;
        }

        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            if (areInterwoven(one, two, three, i + 1, j)) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            return areInterwoven(one, two, three, i, j + 1);
        }

        return false;
    }


    public static boolean interweavingStringsMemoize(String one, String two, String three) {

        if (one.length() + two.length() != three.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];

        return areInterwovenMemoize(one, two, three, 0, 0, cache);
    }


    private static boolean areInterwovenMemoize(String one, String two, String three, int i, int j, Boolean[][] cache) {

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int k = i + j;
        System.out.print("i" + i);
        System.out.println(" j" + j);
        if (k == three.length()) {
            return true;
        }

        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            cache[i][j] = areInterwovenMemoize(one, two, three, i + 1, j, cache);
            if (cache[i][j]) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            cache[i][j] = areInterwovenMemoize(one, two, three, i, j + 1, cache);
            return cache[i][j];
        }

        cache[i][j] = false;
        return cache[i][j];
    }

}
