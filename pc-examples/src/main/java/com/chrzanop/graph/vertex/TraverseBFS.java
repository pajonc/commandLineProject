package com.chrzanop.graph.vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Depth first search
 *
 * @param <T>
 */
public class TraverseBFS<T> {

    public void traverseBasedOnQueue(Vertex<T> vertex) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(vertex);
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.getData());
                queue.addAll(current.getNeighbours());

            }
        }
    }


}
