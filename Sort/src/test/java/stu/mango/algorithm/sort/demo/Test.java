package stu.mango.algorithm.sort.demo;

import stu.mango.algorithm.sort.impl.MergeSortNonRecursive;
import stu.mango.algorithm.util.AlgorithmUtil;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = AlgorithmUtil.generateRandomArray(10, 10);
        System.out.println(Arrays.toString(arr));

        new MergeSortNonRecursive<Integer>().sort(arr, (l, r) -> l-r);
        System.out.println(Arrays.toString(arr));

        // TestUtil.test(new MergeSortNonRecursive<>(), 10,1000);
    }
}
