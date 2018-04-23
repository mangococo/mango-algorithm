package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;
import stu.mango.algorithm.sort.MangoComparable;

/**
 * 递归排序 - 合并
 *
 * @author mangococo
 *
 * 2018/4/18 9:52
 */
abstract class Merge<T> extends AbstractMangoSorter<T> {

    @SuppressWarnings("unchecked")
    void merge(T[] array, int start, int mid, int end, MangoComparable<T> comparable) {
        T[] help = (T[]) new Object[end - start+1];

        int i = 0;
        int p1 = start;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= end) {
            help[i++] = comparable.compare(array[p1], array[p2]) <= 0 ? array[p1++] : array[p2++];
        }

        while (p1 <= mid) {
            System.out.println(p1 + ", " + mid);
            help[i++] = array[p1++];
        }

        while (p2 <= end) {
            help[i++] = array[p2++];
        }

        System.arraycopy(help, 0, array, start, help.length);
    }

}

