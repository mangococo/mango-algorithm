package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;

import java.util.Comparator;

/**
 * @author mangococo
 * <p>
 * 2018/4/24 17:13
 **/
public class HeapSorter<T> extends AbstractMangoSorter<T> {

    private void heapInsert(T[] arr, int index, Comparator<T> comparable) {
        int parent = (index - 1) / 2;
        if (comparable.compare(arr[index], arr[parent]) <= 0) {
            return;
        }

        swap(arr, index, parent);
        heapInsert(arr, parent, comparable);
    }

    private void heapInsertByLoop(T[] arr, int index, Comparator<T> comparable) {
        int parent = (index - 1) / 2;
        while (comparable.compare(arr[index], arr[parent]) > 0) {
            swap(arr, index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }


    @Override
    public void sort(T[] array, Comparator<T> comparable) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            heapInsertByLoop(array, i, comparable);
        }

        int heapSize = array.length;
        swap(array, 0, --heapSize);

        while (heapSize > 0) {
            heapSize = method1(array, heapSize, comparable);
//            heapSize = method2(array, heapSize, comparable);
        }
    }

    private int method1(T[] array, int heapSize, Comparator<T> comparable) {
        for (int i = 0; i < heapSize; i++) {
            heapInsert(array, i, comparable);
        }
        swap(array, 0, --heapSize);

        return heapSize;
    }

    private int method2(T[] array, int heapSize, Comparator<T> comparable) {
        heapify(array, 0, heapSize, comparable);
//        heapifyByLoop(array, 0, heapSize, comparable);
        swap(array, 0, --heapSize);

        return heapSize;
    }

    private void heapify(T[] arr, int index, int size, Comparator<T> comparable) {
        int left = 2*index + 1;
        if (left < size) {
            // 获得左右孩子中较大的
            int largestChild = left + 1 < size && comparable.compare(arr[left+1], arr[left]) > 0 ? left+1 : left;
            if (comparable.compare(arr[largestChild], arr[index]) < 0) {
                return;
            }

            swap(arr, largestChild, index);
            heapify(arr, largestChild, size, comparable);
        }
    }

    private void heapifyByLoop(T[] arr, int index, int size, Comparator<T> comparable) {
        int left = 2*index + 1;
        while (left < size) {
            int largestChild = left + 1 < size && comparable.compare(arr[left+1], arr[left]) > 0 ? left+1 : left;
            if (comparable.compare(arr[largestChild], arr[index]) < 0) {
                return;
            }

            swap(arr, largestChild, index);
            index = largestChild;
            left = 2*index + 1;
        }
    }
}
