package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;
import stu.mango.algorithm.sort.MangoComparable;

public class BubbleSorter<T> extends AbstractMangoSorter<T> {
    @Override
    public void sort(T[] array, MangoComparable<T> comparable) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparable.compare(array[j],  array[j+1]) > 0) {
                    swap(array, j, j+1);
                }
            }
        }
    }
}
