package stu.mango.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mangococo
 * <p>
 * 2018/5/18 21:01
 **/
public class Node<T> {

    /**
     * 结点所包含的数据
     */
    private T data;

    /**
     * 入度
     */
    private int in;

    /**
     * 出度
     */
    private int out;

    /**
     * 该结点的相邻结点
     */
    private final List<Node<T>> nextNodes;

    /**
     * 从该节点出发的边
     */
    private final List<Edge<T>> edges;

    public Node(T data) {
        this.data = data;
        this.in = 0;
        this.out = 0;
        this.nextNodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public int getIn() {
        return in;
    }

    public int getOut() {
        return out;
    }

    public void incIn() {
        this.in++;
    }

    public void incOut() {
        this.out++;
    }

    public void subIn() {
        this.in--;
    }

    public void subOut() {
        this.out--;
    }

    public void addNode(Node<T> node) {
        this.nextNodes.add(node);
    }

    public void addEdge(Edge<T> edge) {
        this.edges.add(edge);
    }

    public List<Node<T>> getNextNodes() {
        return nextNodes;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "[" + this.data +
                "]";
    }
}
