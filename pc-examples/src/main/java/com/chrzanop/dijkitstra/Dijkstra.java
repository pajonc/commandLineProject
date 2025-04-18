package com.chrzanop.dijkitstra;

import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (String vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String currentVertex = currentNode.vertex;

            for (Map.Entry<String, Integer> neighborEntry : graph.get(currentVertex).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int newDistance = distances.get(currentVertex) + weight;

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    priorityQueue.add(new Node(neighbor, newDistance));
                }
            }
        }
        return distances;
    }

    static class Node {
        String vertex;
        int distance;

        Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", Map.of("B", 1, "C", 4));
        graph.put("B", Map.of("A", 1, "C", 2, "D", 5));
        graph.put("C", Map.of("A", 4, "B", 2, "D", 1));
        graph.put("D", Map.of("B", 5, "C", 1));

        Map<String, Integer> distances = dijkstra(graph, "A");
        System.out.println(distances);
    }
}
