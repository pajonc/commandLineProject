package com.chrzanop.coding.hackerrank;

import java.util.*;

public class VectorSimilarity {


    public static void main(String[] args) {

        List<Integer> a_keys = new ArrayList<>(Arrays.asList(2,4));
        List<Double> a_values = new ArrayList<>(Arrays.asList(new Double(3),new Double(8)));

        List<Integer> b_keys = new ArrayList<>(Arrays.asList(2,4));
        List<Double> b_values = new ArrayList<>(Arrays.asList(new Double(1),new Double(2)));

        System.out.println(cosine_similarity(a_keys,a_values,b_keys,b_values));


    }


    public static double cosine_similarity(List<Integer> a_keys, List<Double> a_values, List<Integer> b_keys, List<Double> b_values) {
        double result = 0;

        int aKeysStart = a_keys.get(0);
        int bKeystStart = b_keys.get(0);
        int endAKeysEnd = a_keys.get(a_keys.size() - 1);
        int endBKeysEnd = b_keys.get(b_keys.size() - 1);

        int startKey = Math.min(aKeysStart, bKeystStart);
        int endKey = Math.max(endAKeysEnd, endBKeysEnd);

        Map<Integer, Double> aVector = new HashMap<>();
        for (int i = 0; i < a_keys.size(); i++) {
            aVector.put(a_keys.get(i), a_values.get(i));
        }

        Map<Integer, Double> bVector = new HashMap<>();
        for (int i = 0; i < b_keys.size(); i++) {
            bVector.put(b_keys.get(i), b_values.get(i));
        }


        double dotSum = 0;
        for (int i = startKey; i <= endKey; i++) {
            double aValue = 0;
            double bVal = 0;
            if (aVector.containsKey(i) && bVector.containsKey(i)) {
                dotSum += aVector.get(i) * bVector.get(i);
            }
        }


        double magnitudeA = 0;
        for (Double val : a_values) {
            magnitudeA += val * val;
        }

        magnitudeA = Math.sqrt(magnitudeA);


        double magnitudeB = 0;
        for (Double val : b_values) {
            magnitudeB += val * val;
        }

        magnitudeB = Math.sqrt(magnitudeB);


        result = dotSum / (magnitudeA * magnitudeB);

        return result;

    }

}
