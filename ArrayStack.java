package com.pinfall.exam2;

public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    // 构造函数，初始化栈
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // 入栈操作
    public void push(int item) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = item;
    }

    // 出栈操作
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    // 查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    // 判断栈是否已满
    public boolean isFull() {
        return top == capacity - 1;
    }

    // 获取栈的大小
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
    }
}