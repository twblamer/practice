package io.github.twblamer.practice.util;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public abstract class BaseGraph {
    protected int numVertices;
    protected List<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public BaseGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = (List<Integer>[]) new List[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public abstract void addEdge(int v, int w);

    public List<Integer> getNeighbors(int v) {
        return adjacencyList[v];
    }

    public int getNumberOfVertices() {
        return numVertices;
    }

    public abstract boolean hasCycle();

    public Iterator<Integer> bfs(int startVertex) {
        return new Iterator<Integer>() {
            Queue<Integer> queue = new LinkedList<>();
            boolean visited[] = new boolean[numVertices];
            {
                queue.add(startVertex);
                visited[startVertex] = true;
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Integer next() {
                throwIfEmpty();

                var out = queue.poll();

                for (var n : getNeighbors(out)) {
                    if (!visited[n]) {
                        queue.add(n);
                        visited[n] = true;
                    }
                }

                return out;
            }

            private void throwIfEmpty() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    public Iterator<Integer> dfs(int startVertex) {
        return new Iterator<Integer>() {
            Deque<Integer> stack = new LinkedList<>();
            private boolean[] visited = new boolean[numVertices];
            {
                stack.push(startVertex);
            }

            @Override
            public boolean hasNext() {
                while (!stack.isEmpty()) {
                    if (!visited[stack.peek()]) {
                        return true;
                    } else {
                        stack.pop();
                    }
                }

                return false;
            }

            @Override
            public Integer next() {
                throwIfEmpty();

                var out = stack.pop();

                if (!visited[out]) {
                    visited[out] = true;

                    for (var n : getNeighbors(out)) {
                        if (!visited[n]) {
                            stack.push(n);
                        }
                    }
                }

                return out;
            }

            void throwIfEmpty() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
