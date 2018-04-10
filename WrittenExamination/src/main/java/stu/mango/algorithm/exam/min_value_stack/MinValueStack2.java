package stu.mango.algorithm.exam.min_value_stack;

import java.util.Stack;

/**
 * 该实现下 push 操作稍复杂于 pop 操作。push操作使得minStack最小值记录与dataStack相同，
 * 所以在出栈时，直接对两栈作pop即可。
 */
public class MinValueStack2 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinValueStack2() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * 同时对 minStack 进行 pop 操作，以保证两栈数据的统一
     *
     * @return 数据栈栈顶元素
     */
    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        minStack.pop();
        return dataStack.pop();
    }

    /**
     * 只有当 newData 小于 minStack.top 时，才会将 newData push 进 minStack（保证
     * minStack.top为最小值）。当 newData 大于 minStack.top 时说明最小值未发生改变，
     * 则重复将minStack.top压入栈即可。
     *
     * @param newData 要push 的数据
     */
    public void push(int newData) {
        dataStack.push(newData);
        if (minStack.isEmpty() || minStack.peek() > newData) {
            minStack.push(newData);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public int getMin() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        return minStack.peek();
    }
}
