package graph;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstGraphIterator<N extends Comparable<N>> implements Iterator<N> {
    private Stack<N> stack;
    private Set<N> visited;
    private Graph<N> graph;

    // Constructor initializes the stack and visited set with the start node
    public DepthFirstGraphIterator(N start, Graph<N> graph) {
        this.stack = createStackWith(start);
        this.visited = createSetWith(start);
        this.graph = graph;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public N next() {
        if (!hasNext()) {
            return null;
        }
        N current = popFromStack();
        pushUnvisitedNeighborsOf(current);
        return current;
    }

    // Helper method to create a stack with the start node
    private Stack<N> createStackWith(N start) {
        Stack<N> stack = new Stack<>();
        stack.push(start);
        return stack;
    }

    // Helper method to create a set with the start node
    private Set<N> createSetWith(N start) {
        Set<N> visited = new HashSet<>();
        visited.add(start);
        return visited;
    }

    // Helper method to pop the top element from the stack
    private N popFromStack() {
        return stack.pop();
    }

    // Helper method to push unvisited neighbors of the current node onto the stack
    private void pushUnvisitedNeighborsOf(N current) {
        for (N neighbor : graph.getAdjacentNodes(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                stack.push(neighbor);
            }
        }
    }
}
