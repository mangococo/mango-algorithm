package stu.mango.algorithm.graph.sort;

import stu.mango.algorithm.graph.Graph;
import stu.mango.algorithm.graph.Node;

import java.util.*;

/**
 * 图的拓扑排序：有向无环图
 *
 * @author mangococo
 *
 * <p>
 * 2018/5/21 12:11
 **/
public class TopologySort<T> {

    public List<Node<T>> sort(Graph<T> graph) {

        Map<Node<T>, Integer> inMap = new HashMap<>();

        Queue<Node<T>> zeroInQueue = new LinkedList<>();

        graph.getNodeMap().values().forEach(node -> {
            inMap.put(node, node.getIn());
            if (node.getIn() == 0) {
                zeroInQueue.add(node);
            }
        });

        List<Node<T>> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node<T> cur = zeroInQueue.poll();
            result.add(cur);

            assert cur != null;
            cur.getNextNodes().forEach(next -> {
                inMap.put(next, inMap.get(next)-1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            });

        }

        return result;
    }
}
