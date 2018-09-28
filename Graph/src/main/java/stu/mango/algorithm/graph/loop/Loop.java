package stu.mango.algorithm.graph.loop;

import stu.mango.algorithm.graph.Node;

import java.util.function.Consumer;

/**
 * @author mangococo
 * <p>
 * 2018/5/21 10:50
 **/
public interface Loop<T> {
    void loop(Consumer<Node<T>> action, Node<T> node);
}
