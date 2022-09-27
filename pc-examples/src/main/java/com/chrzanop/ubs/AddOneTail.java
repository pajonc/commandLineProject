package com.chrzanop.ubs;

import java.util.Arrays;
import java.util.Optional;

public class AddOneTail {

    public static void main(String[] args) {
        int[] tt = {1,2};

        int[] dest = new int[tt.length + 1];
        System.arraycopy(tt, 0, dest, 1, tt.length+1);




        Optional.ofNullable("aa").orElse("");

    }

    public int[] addOne(int[] input) {

        int[] result = new int[input.length];
        boolean isAllNine = false, incremented = false;

        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] == 9) {
                result[i] = 0;
                isAllNine = true;
                continue;
            } else {
                if (!incremented) {
                    result[i] = input[i] + 1;
                    incremented = true;
                    isAllNine = false;
                    continue;
                }
                result[i] = input[i];
            }
        }

        if (isAllNine) {
            result = new int[input.length + 1];
            result[0] = 1;
        }

        return result;
    }


    public int[] addOneRec(int[] input) {

        int[] result = new int[input.length];
        boolean isAllNine = false, incremented = false;

        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] == 9) {
                result[i] = 0;
                isAllNine = true;
                continue;
            } else {
                if (!incremented) {
                    result[i] = input[i] + 1;
                    incremented = true;
                    isAllNine = false;
                    continue;
                }
                result[i] = input[i];
            }
        }

        if (isAllNine) {
            result = new int[input.length + 1];
            result[0] = 1;
        }

        return result;
    }


}
