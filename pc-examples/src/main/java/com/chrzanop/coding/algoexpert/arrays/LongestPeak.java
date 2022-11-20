package com.chrzanop.coding.algoexpert.arrays;

public class LongestPeak {

    public static void main(String[] args) {

        int[] array = {1, 3, 2};
        int[] array2 = {0, 1, 2, -1};
        int[] array3 = {0, 1, 1};
        int[] array4 = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        int[] array5 = {1, 1, 3, 2, 1};

        System.out.println(longestPeak(array));
        System.out.println(longestPeak(array2));
        System.out.println(longestPeak(array3));
        System.out.println(longestPeak(array4));
        System.out.println(longestPeak2(array5));
    }


    public static int longestPeak(int[] array) {

        int longestPeakLength = 0;
        int i = 1;
        while (i < array.length - 1) {

            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
            if (!isPeak) {
                i++;
                continue;
            }

            // i-1 and i+1 we know follow strictly decreasing and stritcly increasing
            int leftIdx = i - 1;
            int rightIdx = i + 1;

            // find left decreasing
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx -= 1;
            }

            // find right increasing
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx += 1;
            }

            int currentPeakLength = rightIdx - leftIdx - 1;
            if (currentPeakLength > longestPeakLength) {
                longestPeakLength = currentPeakLength;
            }

            i = rightIdx;

        }


        return longestPeakLength;
    }




    public static int longestPeak2(int[] array) {

        int max = 0;

        for(int i=1; i<array.length -1;i++) {
            if(array[i-1] < array[i] && array[i] > array[i+1]) {

                int currentPeak = calculateCurrentPeak(array, i);

                max = Math.max(currentPeak, max);
            }
        }
        return max;
    }

    public static int calculateCurrentPeak(int[] array, int idx) {
        int peak = 3;
        int leftIdx = idx - 2 ;
        int rightIdx = idx + 2;

        while(leftIdx >= 0 && array[leftIdx] < array[leftIdx+1]) {
            peak +=1;
            leftIdx -=1;
        }

        while(rightIdx <= array.length-1 && array[rightIdx] < array[rightIdx -1 ]){
            peak++;
            rightIdx++;
        }

        return peak;

    }



    // not working
//    public static int longestPeak(int[] array) {
//
//        if(array.length == 0) {
//            return 0;
//        }
//
//        int idxIncreasing = 0;
//        int idxDecresing = 0;
//        boolean changeIncreasing = false;
//        boolean changeDecreasing = false;
//        int counter = 0;
//        int max = 0;
//
//        for (int i = 1; i < array.length; i++) {
//
//            if (changeIncreasing && changeDecreasing) {
//                max = Math.max(max, counter +1);
//                changeIncreasing = false;
//                changeDecreasing = false;
//            }
//
//
//            if (array[i] > array[i-1]) {
//                if (idxDecresing > idxIncreasing) {
//                    idxIncreasing = i;
//                    changeDecreasing = true;
//                } else {
//                    idxIncreasing++;
//                }
//
//                counter++;
//            } else if (array[i] < array[i-1]) {
//
//                if (idxIncreasing > idxDecresing) {
//                    idxDecresing = i;
//                    changeIncreasing = true;
//                } else {
//                    idxDecresing++;
//                }
//                counter++;
//
//            } else if (array[i] == array[i - 1]) {
//                idxIncreasing = i;
//                idxDecresing = i;
//                counter = 0;
//            }
//
//        }
//
//        if (changeIncreasing || changeDecreasing) {
//            max = Math.max(max, counter + 1);
//        }
//
//        return max;
//    }
}
