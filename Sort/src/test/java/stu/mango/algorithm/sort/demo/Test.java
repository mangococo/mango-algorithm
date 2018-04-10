package stu.mango.algorithm.sort.demo;

import stu.mango.algorithm.sort.impl.SelectSort;
import stu.mango.algorithm.sort.util.TestUtil;
import stu.mango.algorithm.util.AlgorithmUtil;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {0, 23, 45, 12, 4, 2, 43, 12, 43, 65, 67};
        System.out.println(AlgorithmUtil.getMax(arr));

        TestUtil.test(new SelectSort<>(),3000);
    }
}
