package io.github.twblamer.practice.util;

public class UndirectedGraph extends BaseGraph {
    public UndirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addEdge(int v, int w) {
        if (!adjacencyList[v].contains(w)) {
            adjacencyList[v].add(w);
        }
    }

    public int countConnectedComponents() {
        boolean[] visited = new boolean[numVertices];
        int count = 0;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                var it = this.dfs(i);
                while (it.hasNext()) {
                    visited[it.next()] = true;
                }

                count++;
            }
        }

        return count;
    }

    @Override
    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean hasCycleUtil(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;

        for (int neighbor : getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
