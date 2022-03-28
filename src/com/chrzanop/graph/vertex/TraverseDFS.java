package com.chrzanop.graph.vertex;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Depth first search
 * @param <T>
 */
public class TraverseDFS<T> {

    public void traverseBasedOnStack(Vertex<T> vertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(vertex);
        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
//            System.out.println(current.getData());
            if(!current.isVisited()) {
                System.out.println(current.getData());
                current.setVisited(true);
                Collections.reverse(current.getNeighbours());
                current.getNeighbours().stream().forEach(tVertex -> stack.push(tVertex));
            }
        }
    }
    public void traverseRecursively(Vertex<T> vertex) {
        while (!vertex.isVisited()) {
            vertex.setVisited(true);
            System.out.println(vertex.getData());
            for (Vertex<T> vertex1 : vertex.getNeighbours()) {
                traverseRecursively(vertex1);
            }
        }
    }

}
