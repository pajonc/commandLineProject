package com.chrzanop.coding.algoexpert.graphs;

import java.util.*;

public class AirportConnections {

    // O(a*(a+r) + a + r + alog(a)) time | O(a+r) space - where a is the number
    // of airports and r is the number of routes
    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
        Map<String, AirportNode> airportGraph = createAirportGraph(airports, routes);
        List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(airportGraph, airports, startingAirport);
        markUnreachableConnections(airportGraph, unreachableAirportNodes);
        return getMinNumberOfConnections(airportGraph, unreachableAirportNodes);
    }

    // O(a+r) time | O(a) space
    private static List<AirportNode> getUnreachableAirportNodes(Map<String, AirportNode> airportGraph, List<String> airports, String startingAirport) {

        List<AirportNode> unreachableAirportNodes = new ArrayList<>();
        Set<String> visitedAirports = new HashSet<>();
        depthFirstTraverseAirports(airportGraph, startingAirport, visitedAirports);

        for (String airport : airports) {
            if (visitedAirports.contains(airport)) continue;
            airportGraph.get(airport).isReachable = false;
            unreachableAirportNodes.add(airportGraph.get(airport));
        }
        return unreachableAirportNodes;
    }

    private static void depthFirstTraverseAirports(Map<String, AirportNode> airportGraph, String airport, Set<String> visitedAirports) {
        if (visitedAirports.contains(airport)) return;
        visitedAirports.add(airport);
        AirportNode airportNode = airportGraph.get(airport);
        for (String connection : airportNode.connections) {
            depthFirstTraverseAirports(airportGraph, connection, visitedAirports);
        }
    }


    // O( a* (a+r)) time | O(a) space
    private static void markUnreachableConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
        for (AirportNode airportNode : unreachableAirportNodes) {
            dfsUnreachableAirports(airportGraph, airportNode, airportNode.airport, new HashSet<>());
        }
    }

    static void dfsUnreachableAirports(Map<String, AirportNode> airportGraph, AirportNode node, String airport, Set<String> visitedAirports) {
        if (visitedAirports.contains(airport)) return;
        if (airportGraph.get(airport).isReachable) return;
        node.unreachableConnections.add(airport);

        List<String> connections = airportGraph.get(airport).connections;
        visitedAirports.add(airport);
        for (String connection : connections) {
            dfsUnreachableAirports(airportGraph, node, connection, visitedAirports);
        }

    }

    // O(alog(a) a+r) time | O(1) space
    private static int getMinNumberOfConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
//        unreachableAirportNodes.sort((a1, a2) -> a2.unreachableConnections.size() - a1.unreachableConnections.size());
//        unreachableAirportNodes.sort(Comparator.comparing(AirportNode::getUnreachableConnections, (a1, a2) -> a2.size() - a1.size()));
//        unreachableAirportNodes.sort(Comparator.comparing(AirportNode::getUnreachableConnections, Comparator.comparingInt(List::size)).reversed());
        unreachableAirportNodes.sort(Comparator.comparingInt((AirportNode airportNode) -> airportNode.getUnreachableConnections().size()).reversed());
        int numberOfNewConnections = 0;
        for (AirportNode airportNode : unreachableAirportNodes) {
            if(airportNode.isReachable) continue;
            for(String connection : airportNode.getUnreachableConnections()){
                airportGraph.get(connection).isReachable = true;
            }
            numberOfNewConnections++;
        }

        return numberOfNewConnections;
    }

    // O(a+r) time | O(a+r) space
    private static Map<String, AirportNode> createAirportGraph(List<String> airports, List<List<String>> routes) {
        Map<String, AirportNode> airportGraph = new HashMap<>();

        for (String airport : airports) {
            airportGraph.put(airport, new AirportNode(airport));
        }

        for (List<String> route : routes) {
            String origin = route.get(0);
            String destination = route.get(1);
            airportGraph.get(origin).connections.add(destination);
        }
        return airportGraph;
    }


    static class AirportNode {
        String airport;
        List<String> connections;
        boolean isReachable;
        List<String> unreachableConnections;

        public AirportNode(String airport) {
            this.airport = airport;
            connections = new ArrayList<>();
            isReachable = true;
            unreachableConnections = new ArrayList<>();
        }

        public String getAirport() {
            return airport;
        }

        public List<String> getConnections() {
            return connections;
        }

        public boolean isReachable() {
            return isReachable;
        }

        public List<String> getUnreachableConnections() {
            return unreachableConnections;
        }
    }
}
