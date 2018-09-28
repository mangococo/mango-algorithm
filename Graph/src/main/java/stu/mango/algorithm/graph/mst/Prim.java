package stu.mango.algorithm.graph.mst;

import stu.mango.algorithm.graph.Edge;
import stu.mango.algorithm.graph.Graph;
import stu.mango.algorithm.graph.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author mangococo
 * <p>
 * 2018/5/24 12:54
 **/
public class Prim<T> {

    public Set<Edge<T>> primMST(Graph<T> graph) {

        PriorityQueue<Edge<T>> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        Set<Node<T>> set = new HashSet<>();

        Set<Edge<T>> result = new HashSet<>();

        graph.getNodeMap().values().forEach(node -> {
            if (!set.contains(node)) {
                set.add(node);
                queue.addAll(node.getEdges());

                while (!queue.isEmpty()) {
                    Edge<T> edge = queue.poll();

                    assert edge != null;
                    Node<T> toNode = edge.getTo();
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        queue.addAll(toNode.getEdges());
                    }

                }
            }

        });

        return result;
    }
}
