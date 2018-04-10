package stu.mango.algorithm.exam.reverse_stack;

import java.util.Stack;

public class ReverseStackByRecursive {
    /**
     * 逆序
     */
    public static void reverse(Stack stack) {
        if (stack.isEmpty()) {
            return;
        }

        Object obj = getAndRemoveBottomEle(stack);
        reverse(stack);
        stack.push(obj);
    }

    /**
     * 获取并"删除"栈底元素
     */
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
