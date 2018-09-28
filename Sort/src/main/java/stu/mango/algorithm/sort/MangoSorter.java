package stu.mango.algorithm.sort;

import java.util.Comparator;

/**
 * @author mangococo
 * @param <T> 待排序序列元素类型
 */
public interface MangoSorter<T> {

    /**
     *
     * @param array 待排序列
     * @param comparable {@link Comparator}
     */
    void sort(T[] array, Comparator<T> comparable);
}
