package stu.mango.algorithm.exam.min_value_stack;

import java.util.Stack;

/**
 * 该实现下 pop 操作稍复杂于 push 操作
 *
 * @author mangococo
 * 2018/4/10 23:57
 */
public class MinValueStack {

    private Stack<Integer> dataStack;

    private Stack<Integer> minStack;

    public MinValueStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    /**
     * 出栈时若当前元素即最小元素（minStack.top）,则需要同时对 minStack 进行 pop 操作，
     * 以保证两栈数据的统一
     *
     * @return 数据栈栈顶元素
     */
    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        int value = dataStack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }

        return value;
    }

    /**
     * 只有当 newData 小于 minStack.top 时，才会将 newData push 进 minStack（保证
     * minStack.top为最小值）
     *
     * @param newData 要push 的数据
     */
    public void push(int newData) {
        dataStack.push(newData);
        if (minStack.isEmpty() || minStack.peek() > newData) {
            minStack.push(newData);
        }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return minStack.peek();
    }
}

