package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;
import stu.mango.algorithm.sort.MangoComparable;

/**
 * 插入排序
 *
 * @author mangococo
 *
 * @see stu.mango.algorithm.sort.MangoSorter
 */
public class InsertSorter<T> extends AbstractMangoSorter<T> {
    @Override
    public void sort(T[] array, MangoComparable<T> comparable) {
        if (array == null || array.length < 2) {
            return;
        }

        // 从第二个元素开始排序
        for (int i = 1; i < array.length; i++) {
            // 插入操作时，因基准值左边元素已有序，当遇到小于自身的元素时则认为已找到要插入的位置
            for (int j = i-1; j >= 0 && comparable.compare(array[j], array[j+1]) > 0; j--) {
                swap(array, j, j+1);
            }
        }
    }
}
