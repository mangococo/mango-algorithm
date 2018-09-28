package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;

import java.util.Comparator;

/**
 * 插入排序
 *
 * @author mangococo
 *
 * @see stu.mango.algorithm.sort.MangoSorter
 */
public class InsertSorter<T> extends AbstractMangoSorter<T> {
    @Override
    public void sort(T[] array, Comparator<T> comparable) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && comparable.compare(array[j], array[j-1]) < 0; j--) {
                swap(array, j, j-1);
            }
        }
    }
}