package stu.mango.algorithm.graph;

/**
 * @author mangococo
 * <p>
 * 2018/5/18 21:01
 **/
public class Edge<T> {

    /**
     * 权重
     */
    private int weight;
//521589ni
    /**
     * 该边的出发结点
     */
    protected Node<T> from;

    /**
     * 该边的目的结点
     */
    private Node<T> to;

    public Edge() {
    }

    public Edge(int weight, Node<T> from, Node<T> to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node<T> getFrom() {
        return from;
    }

    public void setFrom(Node<T> from) {
        this.from = from;
    }

    public Node<T> getTo() {
        return to;
    }

    public void setTo(Node<T> to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "[" + "(" + from +
                ") -" + weight +
                "- (" + to + ")"+ "]";
    }
}
