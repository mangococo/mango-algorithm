package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;

import java.util.Comparator;

/**
 * 冒泡排序
 *
 * @author mangococo
 *
 * @see stu.mango.algorithm.sort.MangoSorter
 */
public class BubbleSorter<T> extends AbstractMangoSorter<T> {
    @Override
    public void sort(T[] array, Comparator<T> comparable) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (comparable.compare(array[j], array[j+1]) > 0) {
                    swap(array, j, j+1);
                }
            }
        }
    }
}
