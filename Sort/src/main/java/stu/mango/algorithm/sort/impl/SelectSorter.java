package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;

import java.util.Comparator;


/**
 * 选择排序
 *
 * @author mangococo
 *
 * @see stu.mango.algorithm.sort.MangoSorter
 */
public class SelectSorter<T> extends AbstractMangoSorter<T> {

    public void sort(T[] array, Comparator<T> comparable) {
        if (array == null || array.length < 2)
            return;

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                minIndex = comparable.compare(array[j], array[minIndex]) < 0 ? j : minIndex;
            }

            swap(array, i, minIndex);
        }

    }
}
