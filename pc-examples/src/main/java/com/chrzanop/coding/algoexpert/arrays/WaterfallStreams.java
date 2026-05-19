package com.chrzanop.coding.algoexpert.arrays;

import java.util.Arrays;

public class WaterfallStreams {

    public double[] waterfallStreams(double[][] array, int source) {

        double[] rowAbove = new double[array[0].length];
        rowAbove[source] = -1;
        double[] calculatedRow = new double[array[0].length];
        for (int row = 1; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (rowAbove[col] == 0) continue;
                if (rowAbove[col] < 0 && array[row][col] == 0) {
                    calculatedRow[col] = rowAbove[col];
                }
                if (rowAbove[col] < 0 && array[row][col] == 1) {
                    calculatedRow[col] = 0;
                    double splitValue = rowAbove[col] / 2;
                    // split left
                    int indexLeft = col - 1;
                    while (indexLeft > 0 && array[row - 1][indexLeft] == 0) {
                        if (array[row][indexLeft] == 0) {
                            calculatedRow[indexLeft] = splitValue;
                            break;
                        }
                        indexLeft--;
                    }
                    // split right
                    int indexRight = col + 1;
                    while (indexRight < array[0].length && array[row - 1][indexRight] == 0) {
                        if (array[row][indexRight] == 0) {
                            calculatedRow[indexRight] = splitValue;
                            break;
                        }
                        indexRight++;
                    }

                }
            }
            rowAbove = calculatedRow.clone();
        }

        double[] finalPercentage = Arrays.stream(rowAbove).map(element -> element * (-100)).toArray();

        return finalPercentage;
    }


    public double[] waterfallStreamsAlgo(double[][] array, int source) {
        double[] rowAbove = array[0];
        // We will use -1 to represent water, since 1 is used for a block
        rowAbove[source] = -1;

        for (int row = 1; row < array.length; row++) {
            double[] currentRow = array[row];
            for (int idx = 0; idx < rowAbove.length; idx++) {
                double valueAbove = rowAbove[idx];

                boolean hasWaterAbove = valueAbove < 0;
                boolean hasBlock = currentRow[idx] == 1.0;

                if (!hasWaterAbove) {
                    continue;
                }

                if (!hasBlock) {
                    // if there is no block in the current column, move the water down
                    currentRow[idx] += valueAbove;
                    continue;
                }

                double splitWater = valueAbove / 2;
                //Move water right
                int rightIdx = idx;
                while (rightIdx + 1 < rowAbove.length) {
                    rightIdx += 1;
                    if (rowAbove[rightIdx] == 1.0) { // if there is a block in the way
                        break;
                    }
                    if (currentRow[rightIdx] != 1.0) { // if there is no block below us
                        currentRow[rightIdx] += splitWater;
                        break;
                    }
                }

                //Move water left
                int leftIdx = idx;
                while (leftIdx - 1 >= 0) {
                    leftIdx -= 1;
                    if (rowAbove[leftIdx] == 1.0) {
                        break;
                    }
                    if (currentRow[leftIdx] != 1.0) {
                        currentRow[leftIdx] += splitWater;
                        break;
                    }
                }
            }

            rowAbove = currentRow;
        }

        double[] finalPercentages = new double[rowAbove.length];

        for (int idx = 0; idx < rowAbove.length; idx++) {
            double num = rowAbove[idx];
            if (num == 0) {
                finalPercentages[idx] = num;
            } else {
                finalPercentages[idx] = (num * -100);
            }
        }

        return finalPercentages;

    }
}
