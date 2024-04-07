package com.pioneertao.algorithm;


import java.util.Stack;

/**
 * 是实现一个栈， 除了基本的 pop/top/push方法外，  还需要一个min方法。 用于返回当前栈的最小值
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current min: " + minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println("Top element after pop: " + minStack.top()); // Output: 0
        System.out.println("Current min: " + minStack.getMin()); // Output: -2
    }
}
