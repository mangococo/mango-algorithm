package stu.mango.algorithm.sort.util;

import stu.mango.algorithm.sort.MangoSorter;
import stu.mango.algorithm.util.AlgorithmUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class SorterTestUtil {
    private static Integer[] arrayClone(Integer[] arr) {
        if (arr == null) {
            return null;
        }

        Integer[] res = new Integer[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);

        return res;
    }

    private static boolean isEqual(Integer[] arr1, Integer[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr2 == null && arr1 != null)) {
            return false;
        }

        if (arr1 == null && arr2 == null) {
            return true;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!Objects.equals(arr1[i], arr2[i])) {
                return false;
            }
        }

        return true;
    }


    /*
     * 对数器
     */
    private static void sort(Integer[] array) {
        Arrays.sort(array, (o1, o2) -> o1 - o2);
    }

    public static void test(MangoSorter<Integer> sort, int size, int testTime) {
        for (int i = 0; i < testTime; i++) {
            Integer[] arr1 = AlgorithmUtil.generateRandomArray(size, 100);
            Integer[] arr2 = arrayClone(arr1);
            Integer[] src = arrayClone(arr1);

            sort.sort(arr1, Comparator.comparingInt(left -> left));
            sort(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("第" + (i+1) + "次测试时失败：");
                System.out.println("\t原序列：" + Arrays.toString(src));
                System.out.println("\t排序算法：" + Arrays.toString(arr1));
                System.out.println("\t正确排序：" + Arrays.toString(arr2));
                return;
            }
        }

        System.out.println("Succeed!");
    }
}
