package stu.mango.algorithm.sort.impl.merge;

import java.util.Comparator;

/**
 *
 * 归并排序 - 递归版
 *
 * @author mangococo
 *
 * 2018/4/18 08:18
 */
public class RecursiveMergeSorter<T> extends Merge<T> {

    @Override
    public void sort(T[] array, Comparator<T> comparable) {
        if (array == null || array.length < 2)
            return;

        mergeSort(array, 0, array.length-1, comparable);
    }

    private void mergeSort(T[] array, int start, int end, Comparator<T> comparable) {
        if (start == end) {
            return;
        }

        int mid = start + ((end - start) >> 1);

        mergeSort(array, start, mid, comparable);
        mergeSort(array, mid+1, end, comparable);
        merge(array, start, mid, end, comparable);
    }

}
