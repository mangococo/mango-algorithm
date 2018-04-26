package stu.mango.algorithm.exam.sort;

/**
 * 求小和之和
 *
 * 基本思想：数组中某元素（x）的左边元素比它小的元素（a, c）的累加和，则x的最小和为 a+c
 * 可以理解为 某元素（假设a）右边部分有k个元素比自身大，则a所产生的小和为 a*k
 * 利用归并排序的思想（甚至过程）完成求小和之和
 *
 * @author mangococo
 * <p>
 * 2018/4/23 14:14
 **/
public class MinSum {

    /**
     * 暴力解 O(n^2)
     */
    public int violenceSolutionMinSum(Integer[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    sum += array[j];
                }
            }
        }
        
        return sum;
    }

    public int getMinSum(Integer[] array) {
        if (array == null) {
            return 0;
        }

        if (array.length < 2) {
            return array[0];
        }

        return solution(array, 0, array.length-1);
    }

    private int solution(Integer[] array, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        int leftSum = solution(array, left, mid);
        int rightSum = solution(array, mid+1, right);
        int sum = merge(array, left, mid, right);

        return sum + leftSum + rightSum;
    }

    private int merge(Integer[] array, int left, int mid, int right) {
        Integer[] help = new Integer[right-left+1];

        int i = 0;
        int p1 = left;
        int p2 = mid+1;

        int sum = 0;



        while (p1 <= mid && p2 <= right) {
            if (array[p1] < array[p2]) {
                sum += (right-p2 + 1) * array[p1]; // 合并时左右两部分都已有序，所以 right-p2 + 1 可表示右边部分比自身大元素个数
                help[i++] =  array[p1++];
            } else {
                help[i++] = array[p2++];
            }
        }

        while (p1 <= mid) {
            help[i++] = array[p1++];
        }

        while (p2 <= right) {
            help[i++] = array[p2++];
        }

        System.arraycopy(help, 0, array, left, help.length);

        return sum;
    }


}
