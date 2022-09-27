package com.chrzanop.graph.leetcode;

import java.util.*;

public class EvaluateDivision {


    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        EvaluateDivision ed = new EvaluateDivision();

        double[] doubles = ed.calcEquation(equations, values, queries);
        System.out.println(doubles);


        List<List<String>> equations2 = new ArrayList<>();
        equations2.add(Arrays.asList("a", "b"));
        equations2.add(Arrays.asList("b", "c"));
        equations2.add(Arrays.asList("c", "d"));
        equations2.add(Arrays.asList("c", "f"));
        equations2.add(Arrays.asList("f", "g"));
        equations2.add(Arrays.asList("a", "e"));
        double[] values2 = {2.0, 3.0, 5.0 , 4, 2, 1};

        List<List<String>> queries2 = new ArrayList<>();
        queries2.add(Arrays.asList("a", "d"));
        queries2.add(Arrays.asList("a", "g"));


        double[] doubles2 = ed.calcEquation(equations2, values2, queries2);

        System.out.println(doubles2);

    }


    class Node {

        String destination;
        double value;

        public Node(String destination, double value) {
            this.destination = destination;
            this.value = value;
        }

        public String getDestination() {
            return destination;
        }

        public double getValue() {
            return value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Node>> graph = buildGraph(equations, values);

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);
            result[i] = dfs(source, destination, graph, new HashSet<>());
        }

        return result;
    }

    private double dfs(String source, String destination, Map<String, List<Node>> graph, Set<String> visited) {

        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            return -1;
        } else if (source.equals(destination)) {
            return 1;
        }

        visited.add(source);
        List<Node> nodes = graph.get(source);

        for (Node node : nodes) {
            if (!visited.contains(node.getDestination())) {
                double ans = dfs(node.getDestination(), destination, graph, visited);
                if (ans != -1) {
                    return ans * node.getValue();
                }
            }
        }

        return -1;
    }

    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            String source = equations.get(i).get(0);
            String destination = equations.get(i).get(1);
            graph.putIfAbsent(source, new ArrayList<>());
            graph.putIfAbsent(destination, new ArrayList<>());
            graph.get(source).add(new Node(destination, values[i]));
            graph.get(destination).add(new Node(source, 1 / values[i]));
        }

        return graph;
    }






    /*
    Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
     */

}
