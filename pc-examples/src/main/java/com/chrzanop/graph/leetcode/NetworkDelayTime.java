package com.chrzanop.graph.leetcode;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime ndt = new NetworkDelayTime();

        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        ndt.networkDelayTime(times, n, k);

    }


    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<String, Integer> nodePairTime = new HashMap<>(times.length);
        for (int i = 0; i < times.length; i++) {
            nodePairTime.put(String.valueOf(times[i][0]) + String.valueOf(times[i][1]), times[i][2]);
        }

        Map<Node, String> nodes = new HashMap<>(n);

        for (int i = 0; i < times.length; i++) {
            Node key1 = new Node(times[i][0]);
            Node key2 = new Node(times[i][1]);
            nodes.putIfAbsent(key1, null);
            nodes.putIfAbsent(key2, null);
            nodes.keySet().stream().filter(node -> node.equals(key1)).findFirst().get().addNeighbour(key2, times[i][2]);
        }

        Set<Node> nodesS = new HashSet<>(n);

        for (int i = 0; i < times.length; i++) {
            Node key1 = new Node(times[i][0]);
            Node key2 = new Node(times[i][1]);
            nodesS.add(key1);
            nodesS.add(key2);

            nodesS.stream().filter(node -> node.equals(key1)).findFirst().get().addNeighbour(key2, times[i][2]);

            key1.addNeighbour(key2, times[i][2]);
        }

        Node root = new Node(k);
        Node rootNode = nodesS.stream().filter(node -> node.equals(root)).findFirst().get();
        Node rootNodeS = nodesS.stream().filter(node -> node.equals(root)).findFirst().get();




        return -1;


    }


    public int bfs(Node root) {

        if(root == null) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int counter = 0;

        while (!queue.isEmpty()) {
            counter++;
            Node current = queue.poll();
            if(current!=null) {
                queue.addAll(current.getNeighboursMapping().keySet());
            }
        }
        
        return -1;

    }


    public class Node {

        private int nodeNumber;
        private boolean visited;
        private Map<Node, Integer> neighboursMapping = new HashMap<>();

        public Node(Integer nodeNumber) {
            this.nodeNumber = nodeNumber;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public Map<Node, Integer> getNeighboursMapping() {
            return neighboursMapping;
        }

        public void addNeighbour(Node neighbour, Integer time) {
            this.neighboursMapping.put(neighbour, time);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return nodeNumber == node.nodeNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nodeNumber);
        }
    }

    /*
    Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    Output: 2
     */

}
