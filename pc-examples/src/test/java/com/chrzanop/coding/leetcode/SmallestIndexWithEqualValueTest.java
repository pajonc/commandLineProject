package com.chrzanop.coding.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class SmallestIndexWithEqualValueTest {

    @Test
    void test() {
        SmallestIndexWithEqualValue smallestIndexWithEqualValue = new SmallestIndexWithEqualValue();
        int[] nums = {4,3,2,1};

        int smallestIndex = smallestIndexWithEqualValue.smallestIndex(nums);

        assertThat(smallestIndex).isEqualTo(2);
    }

    @Test
    void test2() {
        SmallestIndexWithEqualValue smallestIndexWithEqualValue = new SmallestIndexWithEqualValue();
        int[] nums = {0,1,2};

        int smallestIndex = smallestIndexWithEqualValue.smallestIndex(nums);

        assertThat(smallestIndex).isEqualTo(0);
    }

    @Test
    void test3() {
        SmallestIndexWithEqualValue smallestIndexWithEqualValue = new SmallestIndexWithEqualValue();
        int[] nums = {1,2,3,4,5,6,7,8,9,0};

        int smallestIndex = smallestIndexWithEqualValue.smallestIndex(nums);

        assertThat(smallestIndex).isEqualTo(-1);
    }


}