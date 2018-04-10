import stu.mango.algorithm.exam.min_value_stack.MinValueStack1;
import stu.mango.algorithm.exam.min_value_stack.MinValueStack2;
import stu.mango.algorithm.util.AlgorithmUtil;

import java.util.Arrays;

public class Test {



    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Integer[] values = AlgorithmUtil.generateRandomArray(10, 10);
            MinValueStack2 minValueStack1 = new MinValueStack2();
            for (Integer value : values) {
                minValueStack1.push(value);
            }

            if (AlgorithmUtil.getMin(values) != minValueStack1.getMin()) {
                throw new RuntimeException("Wrong!\n"
                        + "\tArrays:" + Arrays.toString(values)
                        + "\tstackMin:" + minValueStack1.getMin()
                        + "\tarrayMin:" + AlgorithmUtil.getMin(values));
            }
        }
        System.out.println("Nice");
    }
}
