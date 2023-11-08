package io.github.twblamer.practice.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.github.twblamer.practice.util.BaseGraph;

public class GraphExercisesTest {
    public interface GraphFactory {
        BaseGraph createGraph(int numVertices);
    }

    public class DirectedGraphFactory implements GraphFactory {
        @Override
        public BaseGraph createGraph(int numVertices) {
            return new DirectedGraphExercises(numVertices);
        }
    }

    public class UndirectedGraphFactory implements GraphFactory {
        @Override
        public BaseGraph createGraph(int numVertices) {
            return new UndirectedGraphExercises(numVertices);
        }
    }

    @Test
    public void testBfs_DirectedGraph() {
        testBfs_Base(new DirectedGraphFactory());
    }

    @Test
    public void testBfs_UndirectedGraph() {
        testBfs_Base(new UndirectedGraphFactory());
    }

    public void testBfs_Base(GraphFactory gf) {
        var g = gf.createGraph(1);
        var bfs = g.bfs(0);
        var tmp = new ArrayList<Integer>();

        tmp.clear();
        while (bfs.hasNext()) {
            tmp.add(bfs.next());
        }
        assertEquals(List.of(0), tmp);

        g = gf.createGraph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        bfs = g.bfs(0);
        tmp.clear();
        while (bfs.hasNext()) {
            tmp.add(bfs.next());
        }
        assertEquals(List.of(0, 1, 2, 3, 4, 5, 6), tmp);
    }

    @Test
    public void testCountConnectedComponents() {
        UndirectedGraphExercises g;
        int actual, expected;

        g = new UndirectedGraphExercises(1);
        actual = g.countConnectedComponents();
        expected = 1;
        assertEquals(expected, actual);

        g.addEdge(0, 0);
        actual = g.countConnectedComponents();
        expected = 1;
        assertEquals(expected, actual);

        g = new UndirectedGraphExercises(2);
        actual = g.countConnectedComponents();
        expected = 2;
        assertEquals(expected, actual);

        g.addEdge(0, 1);
        actual = g.countConnectedComponents();
        expected = 1;
        assertEquals(expected, actual);

        g = new UndirectedGraphExercises(6);
        g.addEdge(0, 5);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        actual = g.countConnectedComponents();
        expected = 3;
        assertEquals(expected, actual);

        g.addEdge(1, 4);
        g.addEdge(3, 4);
        actual = g.countConnectedComponents();
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testDfs_DirectedGraph() {
        testDfs_Base(new DirectedGraphFactory());
    }

    @Test
    public void testDfs_UndirectedGraph() {
        testDfs_Base(new UndirectedGraphFactory());
    }

    public void testDfs_Base(GraphFactory gf) {
        var g = gf.createGraph(1);
        var dfs = g.dfs(0);
        var tmp = new ArrayList<Integer>();

        tmp.clear();
        while (dfs.hasNext()) {
            tmp.add(dfs.next());
        }

        assertEquals(List.of(0), tmp);

        g = gf.createGraph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        dfs = g.dfs(0);
        tmp.clear();
        while (dfs.hasNext()) {
            tmp.add(dfs.next());
        }

        // should not be the same as bfs ordering
        assertNotEquals(List.of(0, 1, 2, 3, 4, 5, 6), tmp);
        tmp.sort(null);
        assertEquals(List.of(0, 1, 2, 3, 4, 5, 6), tmp);
    }

    @Test
    public void testHasCycle_DirectedGraphExercisesh() {
        var g = new DirectedGraphExercises(1);
        assertFalse(g.hasCycle());
        g.addEdge(0, 0);
        assertTrue(g.hasCycle());

        g = new DirectedGraphExercises(2);
        assertFalse(g.hasCycle());
        g.addEdge(0, 1);
        assertFalse(g.hasCycle());
        g.addEdge(1, 0);
        assertTrue(g.hasCycle());

        g = new DirectedGraphExercises(3);
        assertFalse(g.hasCycle());
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        assertFalse(g.hasCycle());
        g.addEdge(2, 0);
        assertTrue(g.hasCycle());

        g = new DirectedGraphExercises(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        assertFalse(g.hasCycle());
        g.addEdge(2, 4);
        assertFalse(g.hasCycle());
        g.addEdge(4, 0);
        assertTrue(g.hasCycle());
    }

    @Test
    public void testHasCycle_UndirectedGraph() {
        UndirectedGraphExercises g;
        boolean expected;

        g = new UndirectedGraphExercises(1);
        expected = false;
        assertEquals(expected, g.hasCycle());

        g.addEdge(0, 0);
        expected = true;
        assertEquals(expected, g.hasCycle());

        g = new UndirectedGraphExercises(2);
        g.addEdge(0, 1);
        expected = false;
        assertEquals(expected, g.hasCycle());

        g = new UndirectedGraphExercises(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        expected = false;
        assertEquals(expected, g.hasCycle());

        g.addEdge(2, 0);
        expected = true;
        assertEquals(expected, g.hasCycle());

        g = new UndirectedGraphExercises(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        expected = false;
        assertEquals(expected, g.hasCycle());

        g.addEdge(2, 4);
        expected = true;
        assertEquals(expected, g.hasCycle());
    }

    @Test
    public void testTopologicalSort_EmptyGraph() {
        DirectedGraphExercises graph = new DirectedGraphExercises(0);
        assertTrue(graph.topologicalSort().isEmpty());
    }

    @Test
    public void testTopologicalSort_SimpleDAG() {
        DirectedGraphExercises graph = new DirectedGraphExercises(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        assertEquals(List.of(0, 1, 2), graph.topologicalSort());
    }

    @Test
    public void testTopologicalSort_ComplexDAG() {
        DirectedGraphExercises graph = new DirectedGraphExercises(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // There can be multiple valid topological sorts
        List<Integer> result = graph.topologicalSort();
        // Check if 5 comes before 2 and 0, 4 comes before 0 and 1, etc.
        assertTrue(result.indexOf(5) < result.indexOf(2));
        assertTrue(result.indexOf(5) < result.indexOf(0));
        assertTrue(result.indexOf(4) < result.indexOf(0));
        assertTrue(result.indexOf(4) < result.indexOf(1));
        assertTrue(result.indexOf(2) < result.indexOf(3));
        assertTrue(result.indexOf(3) < result.indexOf(1));
    }

    @Test
    public void testTopologicalSort_GraphWithCycle() {
        DirectedGraphExercises graph = new DirectedGraphExercises(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        // Since our method doesn't detect cycles, it will still return a result.
        // This test simply verifies the method runs without error.
        // But keep in mind that the result is not a valid topological order.
        assertNotNull(graph.topologicalSort());
    }
}
