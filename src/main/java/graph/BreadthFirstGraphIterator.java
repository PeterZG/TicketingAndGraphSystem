package graph;

import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;

/**
 * An iterator class that performs breadth-first traversal on a graph.
 *
 * @param <N> The node type, which must extend Comparable<N>
 */
public class BreadthFirstGraphIterator<N extends Comparable<N>> implements Iterator<N> {
    private Queue<N> queue;
    private Set<N> visited;
    private Graph<N> graph;

    /**
     * Constructs a new BreadthFirstGraphIterator starting at a given node.
     *
     * @param start The starting node for traversal
     * @param graph The graph to be traversed
     */
    public BreadthFirstGraphIterator(N start, Graph<N> graph) {
        this.queue = createQueueWith(start);
        this.visited = createSetWith(start);
        this.graph = graph;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public N next() {
        if (!hasNext()) {
            return null;
        }
        N current = dequeue();
        enqueueUnvisitedNeighborsOf(current);
        return current;
    }

    /**
     * Creates a queue and adds the given node.
     *
     * @param start The starting node
     * @return A queue containing the given node
     */
    private Queue<N> createQueueWith(N start) {
        Queue<N> queue = new LinkedList<>();
        queue.add(start);
        return queue;
    }

    /**
     * Creates a set and adds the given node.
     *
     * @param start The starting node
     * @return A set containing the given node
     */
    private Set<N> createSetWith(N start) {
        Set<N> visited = new HashSet<>();
        visited.add(start);
        return visited;
    }

    /**
     * Dequeues and returns the next node in the queue.
     *
     * @return The next node in the queue
     */
    private N dequeue() {
        return queue.remove();
    }

    /**
     * Enqueues unvisited neighbors of the given node.
     *
     * @param current The current node whose neighbors should be enqueued
     */
    private void enqueueUnvisitedNeighborsOf(N current) {
        for (N neighbor : graph.getAdjacentNodes(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.add(neighbor);
            }
        }
    }
}
