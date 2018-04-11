package stu.mango.algorithm.exam.stack.queue_with_stack;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> pushStack;

    private Stack<Integer> popStack;

    public StackQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(int newData) {
        pushStack.push(newData);
    }

    /**
     * 每次出栈操作时将压入栈中记录悉数转移至弹出栈！
     */
    public int poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }

    public int peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return popStack.peek();
    }
}
