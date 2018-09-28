package stu.mango.algorithm.tree;

import java.util.Comparator;
import java.util.List;

/**
 * @author mango
 * <p>
 * 2018/9/5 11:56
 **/
public class BinarySearchTree<T> {

    public Node<T> createBinarySearchTree(List<T> valList, Comparator<T> comp) {
        Node<T> root = null;

        for (T val : valList) {
            root = insert(null, val, comp);
        }

        return root;
    }

    public Node<T> search(Node<T> root, T val, Comparator<T> comp) {

        boolean solve = false;
        while (root != null && !solve) {
            if (val.equals(root.getVal())) {
                solve = true;
            } else if (comp.compare(root.getVal(), val) > 0) {
                root = root.getlChild();
            } else {
                root = root.getrChild();
            }
        }

        if (root == null) {
            System.out.println("Not found value [" + val + "] in tree!");
        }

        return root;
    }

    public Node<T> search(Node<T> root, Node<T> node, Comparator<T> comp) {
        return search(root, node.getVal(), comp);
    }

    public Node<T> insert(Node<T> root, Node<T> node, Comparator<T> comp) {
        if (root == null) {
            root = node;
        } else if (comp.compare(node.getVal(), root.getVal()) > 0) {
            root.setlChild(insert(root.getrChild(), node, comp));
        } else {
            root.setrChild(insert(root.getlChild(), node, comp));
        }

        return root;
    }

    public Node<T> insert(Node<T> root, T val, Comparator<T> comp) {
        Node<T> node = new Node<>();
        node.setVal(val);

        return insert(root, node, comp);
    }

}
