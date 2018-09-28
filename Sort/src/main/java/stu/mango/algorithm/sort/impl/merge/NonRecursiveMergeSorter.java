package stu.mango.algorithm.sort.impl.merge;

import java.util.Comparator;

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
public class NonRecursiveMergeSorter<T> extends Merge<T> {
    @Override
    public void sort(T[] array, Comparator<T> comparable) {
        if (array == null || array.length < 2)
            return;

        sortProcess(array, comparable);
    }

    private void sortProcess(T[] array, Comparator<T> comparable) {

        for (int step = 1; step < array.length; step *= 2) {
            for (int i = 0;i+step < array.length; i += 2*step) {
                int mid = i + step -1;
                int right = i + step*2 - 1;

                right = right > array.length-1 ? array.length -1 : right;

                merge(array, i, mid, right, comparable);
            }
        }
    }

}

