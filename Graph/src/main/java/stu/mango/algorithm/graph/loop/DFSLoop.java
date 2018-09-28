package stu.mango.algorithm.graph.loop;

import stu.mango.algorithm.graph.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author mangococo
 * <p>
 * 2018/5/21 11:27
 **/
public class DFSLoop<T> implements Loop<T> {
    @Override
    public void loop(Consumer<Node<T>> action, Node<T> start) {

        Stack<Node<T>> stack = new Stack<>();

        Set<Node<T>> set = new HashSet<>();

        stack.push(start);
        set.add(start);
        action.accept(start);

        while (!stack.isEmpty()) {
            Node<T> cur = stack.pop();

            for (Node<T> next : cur.getNextNodes()) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    action.accept(next);
                    break;
                }
            }
        }


    }
}
