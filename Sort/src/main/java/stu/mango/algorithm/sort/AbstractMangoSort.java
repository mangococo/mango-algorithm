package stu.mango.algorithm.sort;

public abstract class AbstractMangoSort<T> implements MangoSort<T> {
    protected void swap(T[] array, int left, int right) {
        T tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
