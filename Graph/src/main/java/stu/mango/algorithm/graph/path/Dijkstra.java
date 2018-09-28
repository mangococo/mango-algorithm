package stu.mango.algorithm.graph.path;

import stu.mango.algorithm.graph.Edge;
import stu.mango.algorithm.graph.Node;

import java.util.*;

/**
 * @author mangococo
 * <p>
 * 2018/5/26 14:28
 **/
public class Dijkstra<T> {

    public Map<Node<T>, Integer> dijkstra(Node<T> start) {

        Map<Node<T>, Integer> weightMap = new HashMap<>();

        Set<Node<T>> nodes = new HashSet<>();

        weightMap.put(start, 0);
        Node<T> cheapNode = findCheapestNode(start);
        while (cheapNode != null) {

        }


        return weightMap;
    }

    private Node<T> findCheapestNode(Node<T> start) {

        List<Edge<T>> edges = start.getEdges();

        Node<T> cheapestNode = null;
        int minWeight = Integer.MAX_VALUE;

        for (Edge<T> edge : edges) {
            if (edge.getWeight() < minWeight) {
                minWeight = edge.getWeight();
                cheapestNode = edge.getTo();
            }
        }

        return cheapestNode;
    }

}
