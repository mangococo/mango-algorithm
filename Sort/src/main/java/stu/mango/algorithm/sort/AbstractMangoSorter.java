package stu.mango.algorithm.sort;

public abstract class AbstractMangoSorter<T> implements MangoSorter<T> {
    protected void swap(T[] array, int left, int right) {
        T tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
