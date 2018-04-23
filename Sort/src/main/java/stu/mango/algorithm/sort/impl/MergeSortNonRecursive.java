package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.MangoComparable;

/**
 * 归并排序 - 非递归
 *
 * 将数组中的相邻元素两两配对。用merge函数将他们排序，构成n/2组长度为2的排序好的子数组段，
 * 然后再将他们排序成长度为4的子数组段，如此继续下去，直至整个数组排好序。
 *
 * @author mangococo
 * <p>
 * 2018/4/18 13:18
 */
public class MergeSortNonRecursive<T> extends Merge<T> {
    @Override
    public void sort(T[] array, MangoComparable<T> comparable) {
        if (array == null || array.length < 2)
            return;

        sortProcess(array, comparable);
    }

    private void sortProcess(T[] array, MangoComparable<T> comparable) {
        int step = 1;

        while (step < array.length) {
            int i = 0;
            while (i+step < array.length) {
                merge(array, i, i+step/2-1, i+step, comparable);
                i += step;
            }

            merge(array, i, array.length/2, array.length-1, comparable);
            step += step;
        }

        merge(array, 0, array.length/2-1, array.length-1, comparable);
    }

}

