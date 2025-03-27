package com.pinfall.exam2;

public class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full");
        } else {
            stackArray[++top] = value;
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());  // Output: 30
        System.out.println(stack.pop());   // Output: 30
        System.out.println(stack.pop());   // Output: 20
        System.out.println(stack.pop());   // Output: 10
        System.out.println(stack.pop());   // Output: Stack is empty
    }
}