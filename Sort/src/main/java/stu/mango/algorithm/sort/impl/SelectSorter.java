package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;
import stu.mango.algorithm.sort.MangoComparable;

public class SelectSorter<T> extends AbstractMangoSorter<T> {

    public void sort(T[] array, MangoComparable<T> comparable) {
        if (array == null || array.length < 2)
            return;
        int minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i+1; j < array.length; j++) {  // 找出最小值
                if (comparable.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) // 找到最小值，交换
                swap(array, i, minIndex);
        }

    }
}
