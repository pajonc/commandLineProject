package com.chrzanop.graph;

import java.util.Arrays;
import java.util.List;

import static com.chrzanop.graph.VertexFactory.setupVertex;

public class CheckGraph {

    public static void main(String[] args) {
        TraverseDFS traverseDFS = new TraverseDFS();
        TraverseBFS traverseBFS = new TraverseBFS();
        List<Vertex<Integer>> vertices = setupVertex();

        traverseDFS.traverseRecursively(vertices.get(0));

        System.out.println("------------------------------");

        vertices = setupVertex();

        traverseDFS.traverseBasedOnStack(vertices.get(0));

        System.out.println("------------------------------");

        vertices = setupVertex();

        traverseBFS.traverseBasedOnQueue(vertices.get(0));


    }

}
