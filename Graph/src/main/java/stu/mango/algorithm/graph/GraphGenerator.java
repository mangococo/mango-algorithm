package stu.mango.algorithm.graph;

import java.util.Map;

/**
 * @author mangococo
 * <p>
 * 2018/5/18 21:22
 **/
public class GraphGenerator<T> {


    /**
     * @param matrix <[from, to], 权重>
     * @return graph
     */
    public Graph<T> generateGraph(Map<T[], Integer> matrix) {

        Graph<T> graph = new Graph<>();

        matrix.forEach((nodes, weight) -> {
            T from = nodes[0];
            T to = nodes[1];

            Node<T> fromNode = graph.putNode(from);
            Node<T> toNode = graph.putNode(to);

            fromNode.getNextNodes().add(toNode);

            fromNode.incOut();
            toNode.incIn();

            Edge<T> edge = new Edge<>(weight, fromNode, toNode);
            fromNode.addEdge(edge);
            graph.addEdge(edge);

        });

        return graph;
    }
}
