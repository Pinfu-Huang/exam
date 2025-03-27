package com.pinfall.exam2;

// 定义链表节点类
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 定义队列类
public class LinkedListQueue {
    private Node front;
    private Node rear;
    private int size;

    // 构造函数，初始化队列
    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // 入队操作
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // 出队操作
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    // 查看队首元素
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取队列的大小
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }
}
