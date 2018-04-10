import stu.mango.algorithm.exam.cat_dog_queue.Cat;
import stu.mango.algorithm.exam.cat_dog_queue.Dog;
import stu.mango.algorithm.exam.cat_dog_queue.PetQueue;
import stu.mango.algorithm.exam.min_value_stack.MinValueStack1;
import stu.mango.algorithm.exam.reverse_stack.ReverseStackByRecursive;
import stu.mango.algorithm.util.AlgorithmUtil;

import java.util.Arrays;
import java.util.Stack;

public class Test {
    private static void testMinStack() {
        for (int i = 0; i < 10000; i++) {
            Integer[] values = AlgorithmUtil.generateRandomArray(10, 10);
            MinValueStack1 minValueStack1 = new MinValueStack1();
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

    private static void testReverseStack() {
        Stack<Integer> stack = new Stack<>();
        Integer[] array = AlgorithmUtil.generateRandomArray(10, 10);
        System.out.println(Arrays.toString(array));
        for (Integer value : array) {
            System.out.print(value + ", ");
            stack.push(value);
        }
        System.out.println();

        ReverseStackByRecursive.reverse(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void testCatDogQueue() {
        PetQueue petQueue = new PetQueue();
        for (int i = 0; i < 100; i++) {
            boolean isCat = Math.random()*2 < 1;
            if (isCat) {
                System.out.print("cat ");
                petQueue.add(new Cat());
            } else {
                System.out.print("dog ");
                petQueue.add(new Dog());
            }
        }

        System.out.println("\n");
        while (!petQueue.isEmpty()) {
            System.out.print(petQueue.pollAll() + ", ");
        }
    }

    public static void main(String[] args) {
//        testMinStack();
//        testReverseStack();
        testCatDogQueue();
    }
}
