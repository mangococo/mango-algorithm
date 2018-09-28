package stu.mango.algorithm.util;

public class AlgorithmUtil {
    /**
     *
     * @param size 最终生成数组长度 [1, size]
     * @param maxValue [-maxValue, maxValue]
     * @return 长度、内容皆为 int 随机数的数组
     */
    public static Integer[] generateRandomArray(int size, int maxValue) {
        // Math.random() -> double [0, 1)
        Integer[] randomArray = new Integer[(int) ((size+1) * Math.random())+1]; // [1, size]
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) ((maxValue+1) * Math.random()) - (int) ((maxValue) * Math.random());
        }

        return randomArray;
    }

    private static int getMin(Integer[] array, int start, int end) {
        if (start == end) {
            return array[end];
        }

        int mid = start +((end - start) >> 2); // (start+end)/2
        int minLeft = getMin(array, start, mid);
        int minRight = getMin(array, mid+1, end);

        return Math.min(minLeft, minRight);
    }

    private static int getMax(Integer[] arr, int start, int end) {
        if (start == end)
            return arr[start];

        int mid = start + (end - start)/2;
        int leftMax = getMax(arr, start, mid);
        int rightMax = getMax(arr, mid+1, end);

        return Math.max(leftMax, rightMax);
    }

    public static int getMax(Integer[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("Array is empty!");
        }

        return getMax(arr, 0, arr.length-1);
    }

    public static int getMin(Integer[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Array is empty!");
        }

        return getMin(array, 0, array.length-1);
    }
}
