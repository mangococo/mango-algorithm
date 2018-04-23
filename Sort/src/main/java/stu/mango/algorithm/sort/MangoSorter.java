package stu.mango.algorithm.sort;

/**
 * @author mangococo
 * @param <T> 待排序序列元素类型
 */
public interface MangoSorter<T> {

    /**
     *
     * @param array 待排序列
     * @param comparable {@link stu.mango.algorithm.sort.MangoComparable}
     */
    void sort(T[] array, MangoComparable<T> comparable);
}
