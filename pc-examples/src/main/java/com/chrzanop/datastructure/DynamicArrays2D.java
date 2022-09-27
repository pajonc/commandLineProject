package com.chrzanop.datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArrays2D {

    private List<List<Integer>> seqs = new ArrayList<List<Integer>>();
    private int lastAnswer = 0;
    private List<Integer> answerArray = new ArrayList<>();

    public DynamicArrays2D(int n) {
        for (int i = 0; i < n; i++) {
            seqs.add(new ArrayList<>());
        }
        ;
    }

    public void append(int x, int y, int n) {
        int idx = (x ^ lastAnswer) % n;
        seqs.get(idx).add(y);
    }

    public void assign(int x, int y, int n) {
        int idx = (x ^ lastAnswer) % n;
        List<Integer> seq = seqs.get(idx);
        lastAnswer = seq.get(y % seq.size());
        answerArray.add(lastAnswer);
    }


    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        DynamicArrays2D dynamicArrays2D = new DynamicArrays2D(n);
        for (List<Integer> query : queries) {
            if (query.get(0) == 1) {
                dynamicArrays2D.append(query.get(1), query.get(2), n);
            } else {
                dynamicArrays2D.assign(query.get(1), query.get(2), n);
            }
        }
        return dynamicArrays2D.getAnswerArray();

    }

    public List<Integer> getAnswerArray() {
        return answerArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = DynamicArrays2D.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 *
 * Declare a 2-dimensional array, , of  empty arrays. All arrays are zero indexed.
 * Declare an integer, , and initialize it to .
 *
 * There are  types of queries, given as an array of strings for you to parse:
 *
 * Query: 1 x y
 * Let .
 * Append the integer  to .
 * Query: 2 x y
 * Let .
 * Assign the value  to .
 * Store the new value of  to an answers array.
 * Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.  is the modulo operator.
 * Finally, size(arr[idx]) is the number of elements in arr[idx]
 *
 * Function Description
 *
 * Complete the dynamicArray function below.
 *
 * dynamicArray has the following parameters:
 * - int n: the number of empty arrays to initialize in
 * - string queries[q]: query strings that contain 3 space-separated integers
 *
 * Returns
 *
 * int[]: the results of each type 2 query in the order they are presented
 * Input Format
 *
 * The first line contains two space-separated integers, , the size of  to create, and , the number of queries, respectively.
 * Each of the  subsequent lines contains a query string, .
 *
 * Constraints
 *
 * It is guaranteed that query type  will never query an empty array or index.
 * Sample Input
 *
 * 2 5
 * 1 0 5
 * 1 1 7
 * 1 0 3
 * 2 1 0
 * 2 1 1
 * Sample Output
 *
 * 7
 * 3
 * Explanation
 *
 * Initial Values:
 *
 *
 *  = [ ]
 *  = [ ]
 *
 * Query 0: Append  to .
 *
 *  = [5]
 *  = [ ]
 *
 * Query 1: Append  to .
 *  = [5]
 *  = [7]
 *
 * Query 2: Append  to .
 *
 *  = [5, 3]
 *  = [7]
 *
 * Query 3: Assign the value at index  of  to , print .
 *
 *  = [5, 3]
 *  = [7]
 *
 * 7
 * Query 4: Assign the value at index  of  to , print .
 *
 *  = [5, 3]
 *  = [7]
 *
 * 3
 *
 */
