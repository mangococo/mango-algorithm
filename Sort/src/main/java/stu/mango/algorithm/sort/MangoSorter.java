package stu.mango.algorithm.sort;

public interface MangoSorter<T> {
    void sort(T[] array, MangoComparable<T> comparable);
}
