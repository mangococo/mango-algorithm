package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;
import stu.mango.algorithm.sort.MangoComparable;

/**
 * @author mangococo
 * <p>
 * 2018/4/18 9:52
 */
public class MergeSort<T> extends AbstractMangoSorter<T> {

    @Override
    public void sort(T[] array, MangoComparable<T> comparable) {
        if (array == null || array.length < 2)
            return;

        sort(array, 0, array.length-1, comparable);
    }

    private void sort(T[] array, int start, int end, MangoComparable<T> comparable) {
        if (start == end) {
            return;
        }

        int mid = start + ((end - start) >> 1);// end - ((end - start) >> 1);  // TODO 错误

        sort(array, start, mid, comparable);
        sort(array, mid+1, end, comparable);
        merge(array, start, mid, end, comparable);
    }

    @SuppressWarnings("unchecked")
    protected void merge(T[] array, int start, int mid, int end, MangoComparable<T> comparable) {
        T[] help = (T[]) new Object[end - start+1];

        int i = 0;
        int p1 = start;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= end) {
            help[i++] = comparable.compare(array[p1], array[p2]) <= 0 ? array[p1++] : array[p2++];
        }

        while (p1 <= mid) {
            help[i++] = array[p1++];
        }

        while (p2 <= end) {
            help[i++] = array[p2++];
        }

        System.arraycopy(help, 0, array, start, help.length);
    }

}

