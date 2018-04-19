package stu.mango.algorithm.sort.demo;

import stu.mango.algorithm.sort.impl.NonRecursiveMergeSort;
import stu.mango.algorithm.sort.util.TestUtil;

public class Test {
    public static void main(String[] args) {
        TestUtil.test(new NonRecursiveMergeSort<>(), 10,1000);
    }
}
