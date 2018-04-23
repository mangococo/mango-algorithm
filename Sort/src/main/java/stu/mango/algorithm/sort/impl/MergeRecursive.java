package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.MangoComparable;

/**
 *
 * 归并排序 - 递归版
 *
 * @author mangococo
 *
 * 2018/4/18 08:18
 */
public class MergeRecursive<T> extends Merge<T> {

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

}
