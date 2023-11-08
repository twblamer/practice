package io.github.twblamer.practice.exercises;

import java.util.Iterator;
import java.util.List;

import io.github.twblamer.practice.util.DirectedGraph;

/**
 * @see GraphExercisesTest
 */
public class DirectedGraphExercises extends DirectedGraph {
    // protected int numVertices;
    // protected List<Integer>[] adjacencyList;

    // public List<Integer> getNeighbors(int v)

    public DirectedGraphExercises(int numVertices) {
        super(numVertices);
    }

    //
    // Start here
    //
    @Override
    public Iterator<Integer> bfs(int startVertex) {
        return super.bfs(startVertex);
    }

    @Override
    public Iterator<Integer> dfs(int startVertex) {
        return super.dfs(startVertex);
    }

    @Override
    public boolean hasCycle() {
        return super.hasCycle();
    }

    @Override
    public List<Integer> topologicalSort() {
        return super.topologicalSort();
    }
}
