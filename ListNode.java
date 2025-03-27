package com.pinfall.exam2;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        next = null;
    }
}

class Queue {
    private ListNode front, rear;

    Queue() {
        front = rear = null;
    }

    void enqueue(int value) {
        ListNode newNode = new ListNode(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int value = front.value;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return value;
        }
    }

    int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return front.value;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.peek());  // Output: 10
        System.out.println(queue.dequeue());  // Output: 10
        System.out.println(queue.dequeue());  // Output: 20
        System.out.println(queue.dequeue());  // Output: 30
        System.out.println(queue.dequeue());  // Output: Queue is empty
    }
}