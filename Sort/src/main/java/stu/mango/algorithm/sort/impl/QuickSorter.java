package stu.mango.algorithm.sort.impl;

import stu.mango.algorithm.sort.AbstractMangoSorter;
import stu.mango.algorithm.sort.MangoComparable;


public class QuickSorter<T> extends AbstractMangoSorter<T> {

    public void sort(T[] array, MangoComparable<T> comparable) {
        if (array == null || array.length < 2) {
            return;
        }

        quickSort(array, comparable);
    }

    @SuppressWarnings("unchecked")
    private void quickSort(T[] array, MangoComparable<T> comparable) {
        T[] sortedArray = array.clone();
        for (int i = 0; i < array.length; i++) {
            int smallestIndex = findSmallest(array, comparable);
            System.out.println(smallestIndex);
            sortedArray[i] = array[smallestIndex];
        }
    }

    private int findSmallest(T[] array, MangoComparable<T> comparable) {
        T smallestEle = array[0];
        int smallestIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (comparable.compare(smallestEle, array[i]) > 0) {
                smallestEle = array[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }
}
