package com.chrzanop.backbase;

import java.util.ArrayList;
import java.util.List;

public class SubsetsOfString {

    public static List<String> findSubsets(String s) {
        List<String> subsets = new ArrayList<>();
        int n = s.length();

        // Iterate through all possible subsets using bit manipulation
        for (int i = 0; i < (1 << n); i++) { // 1 << n is equivalent to 2^n
            StringBuilder subset = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit is set in i
                if ((i & (1 << j)) != 0) {
                    subset.append(s.charAt(j));
                }
            }
            subsets.add(subset.toString());
        }

        return subsets;
    }

    public static List<String> findSubsetsIteratively(String s) {
        List<String> subsets = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            char character = s.charAt(i);
            subsets.add(String.valueOf(character));
            builder.append(String.valueOf(character));
            for (int j = i + 1; j < n; j++) {
                StringBuilder append = builder.append(s.charAt(j));
                subsets.add(append.toString());
            }
        }

        return subsets;
    }



    public static void main(String[] args) {
        String str = "ANIL";

        List<String> subsets = findSubsets(str);

        System.out.println("sub : " + subsets);

        List<String> subsets2 = findSubsetsIteratively(str);

        System.out.println("sub2 : " + subsets2);

        String str2 = "abc";

        List<String> subsets1 = findSubsets(str2);

        System.out.println("subsets1 " +subsets1 );

    }


}
