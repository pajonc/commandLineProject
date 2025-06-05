package com.chrzanop.collections;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class PartitionUtil {

    public static void main(String[] args) {
        List<Integer> aL = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        Lists.partition(aL, 3).forEach(el -> System.out.println(el));

    }
}
