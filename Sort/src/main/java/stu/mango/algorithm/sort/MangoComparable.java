package stu.mango.algorithm.sort;

/**
 * 待排序排序比较原则（可使用lambda表达式）
 *
 * @author mangococo
 *
 * @see stu.mango.algorithm.sort.MangoSorter
 */
@FunctionalInterface
public interface MangoComparable<T> {
    /**
     *
     * @param left 比较左元素
     * @param right 比较右元素
     * @return 返回结果：大于0（left > right）, 等于0（left=right), 小于0()
     */
    int compare(T left, T right);
}
