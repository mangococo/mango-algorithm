package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;
import stu.mango.algorithm.sort.MangoComparable;

/**
 * 非递归思想:
 * 将数组中的相邻元素两两配对。用merge函数将他们排序，构成n/2组长度为2的排序好的子数组段，
 * 然后再将他们排序成长度为4的子数组段，如此继续下去，直至整个数组排好序。
 *
 * @author mangococo
 * <p>
 * 2018/4/18 13:18
 */
public class NonRecursiveMergeSort<T> extends AbstractMangoSorter<T> {
    @Override
    public void sort(T[] array, MangoComparable<T> comparable) {
        if (array == null || array.length < 2)
            return;

        sortProcess(array, comparable);
    }

    private void sortProcess(T[] array, MangoComparable<T> comparable) {
        MergeSort<T> mergeSort = new MergeSort<>();

        for (int step = 2; step <= array.length; step *= 2) {
            int i;
            for (i = 0; i + step <= array.length; i += step) {
                mergeSort.merge(array, i, i + step / 2 - 1, i + step - 1, comparable);
            }

            mergeSort.merge(array, i, i + step / 2 - 1, array.length - 1, comparable);
        }

        mergeSort.merge(array, 0, array.length / 2 - 1, array.length - 1, comparable);

    }

}

