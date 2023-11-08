package io.github.twblamer.practice.util;

import java.awt.Dimension;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;

class VisualizeImpl {
    static void visualize(BaseGraph g) {
        DefaultDirectedGraph<String, DefaultEdge> directedGraph = new DefaultDirectedGraph<>(DefaultEdge.class);

        for (int i = 0; i < g.numVertices; i++) {
            directedGraph.addVertex(String.valueOf(i));
        }

        for (int i = 0; i < g.numVertices; i++) {
            var v1 = String.valueOf(i);
            var targets = g.adjacencyList[i];
            for (var v2 : targets.stream().map(String::valueOf).collect(Collectors.toList())) {
                directedGraph.addEdge(v1, v2);
            }
        }

        JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(directedGraph);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));
        mxGraphComponent graphComponent = new mxGraphComponent(graphAdapter);
        frame.getContentPane().add(graphComponent);
        frame.pack();
        frame.setVisible(true);
    }
}
