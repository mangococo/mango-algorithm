package stu.mango.algorithm.sort;


/**
 * 定义基础交换方法
 *
 * @author mangococo
 *
 * @see stu.mango.algorithm.sort.MangoSorter
 */
public abstract class AbstractMangoSorter<T> implements MangoSorter<T> {
    protected void swap(T[] array, int left, int right) {
        T tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
