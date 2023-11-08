package io.github.twblamer.practice.exercises;

import java.util.Iterator;

import io.github.twblamer.practice.util.UndirectedGraph;

/**
 * @see GraphExercisesTest
 */
public class UndirectedGraphExercises extends UndirectedGraph {
    // protected int numVertices;
    // protected List<Integer>[] adjacencyList;

    // public List<Integer> getNeighbors(int v)

    public UndirectedGraphExercises(int numVertices) {
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
    public int countConnectedComponents() {
        return super.countConnectedComponents();
    }

    @Override
    public Iterator<Integer> dfs(int startVertex) {
        return super.dfs(startVertex);
    }

    @Override
    public boolean hasCycle() {
        return super.hasCycle();
    }
}
