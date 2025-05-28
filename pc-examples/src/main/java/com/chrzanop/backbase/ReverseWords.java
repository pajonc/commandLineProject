package com.chrzanop.backbase;

public class ReverseWords {

    public static String reverseWords(String sentence) {
        sentence = sentence.trim().replaceAll(" +", " ");

        char[] sentenceArray = sentence.toCharArray();
        int strLen = sentenceArray.length;

        strRev(sentenceArray, 0, strLen - 1);
        int start = 0;

        for (int end = 0; end <= strLen; end++) {
            if (end == strLen || sentenceArray[end] == ' ') {
                strRev(sentenceArray, start, end - 1);
                start = end + 1;
            }
        }

        return new String(sentenceArray);
    }

    public static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }

    public static void main(String[] args) {
        String s = "Hello World!";
        System.out.println(s);
        System.out.println(reverseWords(s));
    }
}
