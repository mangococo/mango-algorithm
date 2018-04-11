import stu.mango.algorithm.exam.queue.cat_dog_queue.Cat;
import stu.mango.algorithm.exam.queue.cat_dog_queue.Dog;
import stu.mango.algorithm.exam.queue.cat_dog_queue.PetQueue;
import stu.mango.algorithm.exam.stack.min_value_stack.MinValueStack1;
import stu.mango.algorithm.exam.stack.reverse_stack.ReverseStackByRecursive;
import stu.mango.algorithm.exam.stack.sort_stack_by_other_stack.StackSorter;
import stu.mango.algorithm.util.AlgorithmUtil;

import java.util.Arrays;
import java.util.Stack;

public class Test {
    private static Stack<Integer> createStack(int size, int maxValue) {
        Stack<Integer> stack = new Stack<>();
        Integer[] array = AlgorithmUtil.generateRandomArray(size, maxValue);

        System.out.println(Arrays.toString(array));
        for (Integer value : array) {
            stack.push(value);
        }

        return stack;
    }


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
        Stack<Integer> stack = createStack(10, 10);

        ReverseStackByRecursive.reverse(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void testCatDogQueue() {
        PetQueue petQueue = new PetQueue();
        for (int i = 0; i < 100; i++) {
            boolean isCat = Math.random()*2 < 1;
            if (isCat) {
                System.out.print("cat, ");
                petQueue.add(new Cat());
            } else {
                System.out.print("dog, ");
                petQueue.add(new Dog());
            }
        }

        System.out.println("\n" + petQueue.size());

        petQueue.pollCat();
        petQueue.pollDog();

        System.out.println("size:" + petQueue.size() + ", catSize:" + petQueue.catsSize()
                + ", dogSize:" + petQueue.dogsSize());
        petQueue.add(new Dog());

        System.out.println("Header:" + petQueue.peek());
        System.out.println("dogSize:" + petQueue.dogsSize());
        while (!petQueue.isEmpty()) {
            System.out.print(petQueue.poll() + ", ");
        }
    }

    public static void testStackSort() {
        Stack<Integer> stack = createStack(10, 20);
        StackSorter.sortStackByOtherStack(stack);
        System.out.println(stack.toString());
    }

    public static void main(String[] args) {
//        testMinStack();
//        testReverseStack();
//        testCatDogQueue();
        testStackSort();
    }
}
