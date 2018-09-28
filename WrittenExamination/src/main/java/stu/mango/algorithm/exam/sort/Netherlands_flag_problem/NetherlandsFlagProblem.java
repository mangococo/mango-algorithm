package stu.mango.algorithm.exam.sort.Netherlands_flag_problem;

/**
 * @author mangococo
 * <p>
 * 2018/4/24 15:52
 **/
public class NetherlandsFlagProblem {
    /**
     *
     * @param arr 待划分数组
     * @param left 数组区域左边界
     * @param right 数组区域右边界
     */
    public void partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;

        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr,  left++, ++less);
            } else if (arr[left] > arr[right]) {
                swap(arr, left, --more);
            } else {
                left++;
            }
        }

        swap(arr, right, more);
    }

    /**
     * 以数组划定区域的最后一个元素作为划分值，以该划分值为基准定义两个区域（小于等于区，大于区）。将cur与划分值比较
     * cur <= 划分值，cur与小于区下一位置元素交换，并将小于区位置扩增一个位置；cur > 划分值 do nothing.
     *
     * @param arr 数组
     * @param left 数组区域左边界
     * @param right 数组区域右边界
     */
    public void simplePartition(int[] arr, int left, int right) {
        int point = arr[right];
        int less = left-1;

        for (int i = left; i <= right; i++) {
            if (arr[i] <= point) {
                swap(arr, ++less, i);
            }
        }

        System.out.println(less);
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
