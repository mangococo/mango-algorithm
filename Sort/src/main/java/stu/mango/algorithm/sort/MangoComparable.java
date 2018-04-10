package stu.mango.algorithm.sort;

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
