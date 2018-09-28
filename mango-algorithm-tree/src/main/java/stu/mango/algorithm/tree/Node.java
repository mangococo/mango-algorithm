package stu.mango.algorithm.tree;

/**
 * @author mango
 * <p>
 * 2018/9/5 11:04
 **/
public class Node<T> {

    private T val;

    private Node<T> lChild;

    private Node<T> rChild;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node<T> getlChild() {
        return lChild;
    }

    public void setlChild(Node<T> lChild) {
        this.lChild = lChild;
    }

    public Node<T> getrChild() {
        return rChild;
    }

    public void setrChild(Node<T> rChild) {
        this.rChild = rChild;
    }
}
