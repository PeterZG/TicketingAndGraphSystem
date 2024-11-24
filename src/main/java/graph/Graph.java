package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * A class that implements an undirected graph using a HashMap.
 * @param <N> Node type. The node type must implement the Comparable interface so
 *            we can sort a collection of nodes.
 */
public class Graph<N extends Comparable<N>> implements Iterable<N> {
    private HashMap<N, List<N>> graph = new HashMap<>();
    private N start;

    /**
     * Adds the given node to the graph.
     */
    public void addNode(N node) {
        if (graph.isEmpty()) {
            start = node;
        }
        graph.put(node, new ArrayList<>());
    }

    /**
     * Adds an edge between node1 and node2.
     * @precondition node1 and node2 are nodes in the graph.
     * @postcondition If there is already a connection present between the two
     *                nodes, does nothing.
     */
    public void addConnection(N node1, N node2) {
        List<N> node1Adjacencies = graph.get(node1);
        if (!node1Adjacencies.contains(node2)) {
            node1Adjacencies.add(node2);
            Collections.sort(node1Adjacencies);

            List<N> node2Adjacencies = graph.get(node2);
            node2Adjacencies.add(node1);
            Collections.sort(node2Adjacencies);
        }
    }

    /**
     * Removes the node and its linked edges from the graph.
     * @precondition node is in the graph.
     * @postcondition All original neighbors no longer have an edge connected to the node.
     *                Node removed from the graph.
     * @param node The node to be removed.
     */
    public void removeNode(N node) {
        List<N> nodeAdjacencies = graph.get(node);

        // Remove target node from each neighbor's adjacency list.
        for (N neighbor : nodeAdjacencies) {
            graph.get(neighbor).remove(node);
        }

        // Remove target node from the graph.
        graph.remove(node);
    }

    /**
     * Retrieves all the nodes adjacent to the given node.
     * @precondition node is in the graph.
     * @return A list of adjacent nodes.
     */
    public List<N> getAdjacentNodes(N node) {
        return new ArrayList<>(graph.get(node));
    }

    public Iterator<N> breadthFirstIterator(N start) {
        return new BreadthFirstGraphIterator<>(start, this);
    }

    public Iterator<N> depthFirstIterator(N start) {
        return new DepthFirstGraphIterator<>(start, this);
    }

    @Override
    public Iterator<N> iterator() {
        return breadthFirstIterator(start);
    }
}
