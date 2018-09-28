package stu.mango.algorithm.sort.demo;

import stu.mango.algorithm.sort.impl.HeapSorter;
import stu.mango.algorithm.sort.util.SorterTestUtil;

public class Test {
    public static void main(String[] args) {
        SorterTestUtil.test(new HeapSorter<>(), 10,100);
    }
}
