package stu.mango.algorithm.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mangococo
 * <p>
 * 2018/5/18 21:01
 **/
public class Graph<T> {

    /**
     * 节点的集合
     * key
     */
    private final Map<T, Node<T>> nodeMap;

    /**
     * 边的集合
     */
    private final Set<Edge<T>> edgeSet;

    public Graph() {
        nodeMap = new HashMap<>();
        edgeSet = new HashSet<>();
    }

    public Map<T, Node<T>> getNodeMap() {
        return nodeMap;
    }


    public Set<Edge<T>> getEdgeSet() {
        return edgeSet;
    }

    public Node<T> putNode(T id) {
        if (nodeMap.containsKey(id)) {
            return nodeMap.get(id);
        }

        Node<T> node = new Node<>(id);
        nodeMap.put(id, node);

        return node;
    }

    public void putNode(Node<T> node) {
        if (nodeMap.containsValue(node)) {
            return;
        }

        nodeMap.put(node.getData(), node);
    }

    public void addEdge(Edge<T> edge) {
        this.edgeSet.add(edge);
    }
}
