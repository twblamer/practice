package io.github.twblamer.practice.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraph extends BaseGraph {
    public DirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addEdge(int v, int w) {
        if (!adjacencyList[v].contains(w)) {
            adjacencyList[v].add(w);
        }
    }

    @Override
    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];
        boolean[] stackArray = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, stackArray)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int v, boolean[] visited, boolean[] stackArray) {
        if (stackArray[v])
            return true;

        if (visited[v])
            return false;

        visited[v] = true;
        stackArray[v] = true;

        for (int child : getNeighbors(v)) {
            if (hasCycleUtil(child, visited, stackArray))
                return true;
        }

        stackArray[v] = false;
        return false;
    }

    public List<Integer> topologicalSort() {
        var stack = new LinkedList<Integer>();
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    private void topologicalSortUtil(int v, boolean[] visited, Deque<Integer> stack) {
        visited[v] = true;
        for (int adjVertex : getNeighbors(v)) {
            if (!visited[adjVertex]) {
                topologicalSortUtil(adjVertex, visited, stack);
            }
        }
        stack.push(v);
    }
}
