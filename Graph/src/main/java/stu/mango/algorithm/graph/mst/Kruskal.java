package stu.mango.algorithm.graph.mst;

import stu.mango.algorithm.graph.Edge;
import stu.mango.algorithm.graph.Graph;
import stu.mango.algorithm.graph.Node;

import java.util.*;

/**
 * Minimum Spanning Tree
 *
 * 并查集 + 优先队列
 *
 * @author mangococo
 * <p>
 * 2018/5/21 15:27
 **/
public class Kruskal<T> {

    /**
     * Disjoint Set Union 并查集
     */
    class DSU<E> {

        private Map<E, E> mappingMap;

        private Map<E, Integer> sizeMap;

        DSU(Collection<E> es) {
            mappingMap = new HashMap<>();
            sizeMap = new HashMap<>();

            es.forEach(data -> {
                mappingMap.put(data, data); // 初始：每个节点指向了自己
                sizeMap.put(data, 1);
            });
        }

        E findParent(E ele) {
            E parent = mappingMap.get(ele);
            if (parent != ele) {
                parent = findParent(parent);
            }

            mappingMap.put(ele, parent);

            return parent;
        }

        boolean isSameSet(E n1, E n2) {
            return findParent(n1) == findParent(n2);
        }

        void union(E n1, E n2) {
            E parent1 = mappingMap.get(n1);
            E parent2 = mappingMap.get(n2);

            if (parent1 == parent2) {
                return;
            }

            int size1 = sizeMap.get(parent1);
            int size2 = sizeMap.get(parent2);

            if (size1 <= size2) {
                mappingMap.put(parent1, parent2);
                sizeMap.put(parent2, size1+size2);
            } else {
                mappingMap.put(parent2, parent1);
                sizeMap.put(parent1, size1+size2);
            }
        }
    }

    public Set<Edge<T>> kruskalMST(Graph<T> graph) {

        DSU<Node<T>> nodeDSU = new DSU<>(graph.getNodeMap().values());


        PriorityQueue<Edge<T>> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        queue.addAll(graph.getEdgeSet());

        Set<Edge<T>> result = new HashSet<>();
        while (!queue.isEmpty()) {
            Edge<T> edge = queue.poll();
            assert edge != null;
            if (!nodeDSU.isSameSet(edge.getFrom(), edge.getTo())) {
                result.add(edge);
                nodeDSU.union(edge.getFrom(), edge.getTo());
            }
        }

        return result;
    }
}
