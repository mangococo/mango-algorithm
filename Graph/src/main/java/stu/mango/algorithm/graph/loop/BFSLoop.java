package stu.mango.algorithm.graph.loop;

import stu.mango.algorithm.graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author mangococo
 * <p>
 * 2018/5/21 10:46
 **/
public class BFSLoop<T> implements Loop<T> {

    @Override
    public void loop(Consumer<Node<T>> action, Node<T> node) {

        Queue<Node<T>> queue = new LinkedList<>();

        Set<Node<T>> nodeSet = new HashSet<>();

        queue.add(node);
        nodeSet.add(node);


        while (!queue.isEmpty()) {
            Node<T> cur = queue.poll();

            action.accept(cur);

            assert cur != null;
            for (Node<T> next : cur.getNextNodes()) {
                if (!nodeSet.contains(next)) {
                    nodeSet.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
