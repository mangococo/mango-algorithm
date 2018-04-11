package stu.mango.algorithm.exam.stack.sort_stack_by_other_stack;

import java.util.Stack;

/**
 * @author mangococo
 *
 * <p>
 * 2018/4/11 10:41
 */
public class StackSorter {
    public static void sortStackByOtherStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() < 2)
            return;
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            int cur = stack.pop();
//            if (help.isEmpty() || help.peek() >= cur) {
//                help.push(cur);
//            } else {
//                while (!help.isEmpty() && help.peek() >= cur) {
//                    stack.push(help.pop());
//                }
//            }
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }

            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
