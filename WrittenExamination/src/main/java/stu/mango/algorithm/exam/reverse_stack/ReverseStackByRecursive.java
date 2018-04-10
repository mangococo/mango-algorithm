package stu.mango.algorithm.exam.reverse_stack;

import java.util.Stack;

public class ReverseStackByRecursive {
    public static void reverse(Stack stack) {
        if (stack.isEmpty()) {
            return;
        }

        Object obj = getAndRemoveBottomEle(stack);
        reverse(stack);
        stack.push(obj);
    }

    private static Object getAndRemoveBottomEle(Stack stack) {
        Object result = stack.pop();

        if (stack.isEmpty()) {
            return result;
        }

        Object last = getAndRemoveBottomEle(stack);
        stack.push(result);

        return last;
    }
}
