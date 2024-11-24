package graph;

import java.util.ArrayList;
import java.util.List;

public class Invalidation {

    /**
     * Demonstrates graph invalidation by removing nodes from the graph during iteration.
     */
    private static void graphInvalidation() {
        Graph<Integer> graph = new Graph<>();

        // Add nodes to the graph.
        graph.addNode(5);
        graph.addNode(4);
        graph.addNode(7);

        // Create a degenerate graph (a line).
        graph.addConnection(5, 4);
        graph.addConnection(4, 7);

        // Iterate through the graph and remove nodes based on a condition.
        for (Integer val1 : graph) {
            System.out.println(val1);
            for (Integer val2 : graph) {
                if (val1 > val2) {
                    graph.removeNode(val2);
                }
            }
        }
    }

    /**
     * Demonstrates list invalidation by removing elements from the list during iteration.
     */
    private static void listInvalidation() {
        List<Integer> list = new ArrayList<>();

        // Add elements to the list.
        list.add(5);
        list.add(4);
        list.add(7);

        // Iterate through the list and remove elements based on a condition.
        for (Integer val1 : list) {
            System.out.println(val1);
            for (Integer val2 : list) {
                if (val1 > val2) {
                    list.remove(val2);
                }
            }
        }
    }

    public static void main(String[] args) {
        graphInvalidation();
        listInvalidation();
    }
}

