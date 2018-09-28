package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;

import java.util.Comparator;

/**
 * 随机快速排序（为了避免经典快速排序所出现最差情况）
 *
 * 此处所说的“随机”是指随机选出划分值。由于经典快速排序每次都以最后一个值为划分值，
 * 其存在最优和最差时间复杂度（每次递归过程选取的划分值分别是“中值“和”最小/最大“）。
 *
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小；
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * @author mangococo
 *
 * @see stu.mango.algorithm.sort.MangoSorter
 */
public class QuickSorter<T> extends AbstractMangoSorter<T> {

    public void sort(T[] array, Comparator<T> comparable) {
        if (array == null || array.length < 2) {
            return;
        }

        quickSort(array, 0, array.length-1, comparable);
    }

    private void quickSort(T[] array, int left, int right, Comparator<T> comparable) {
        if (left < right) {
            swap(array, left + (int) (Math.random() * (right -left + 1)), right);
            int[] index = partition(array, left, right, comparable);
            quickSort(array, left, index[0], comparable);
            quickSort(array, index[1], right, comparable);
        }
    }

    private int[] partition(T[] arr, int start, int end, Comparator<T> comparable) {
        int less = start - 1;
        int more = end;

        while (start < more) {
            if (comparable.compare(arr[start], arr[end]) < 0) {
                swap(arr, start++, ++less);
            } else if (comparable.compare(arr[start], arr[end]) > 0) {
                swap(arr, start, --more);
            } else {
                start++;
            }
        }

        swap(arr, end, more++);

        return new int[]{less, more};
    }

}