package com.geeks.ds.queue;

/**
 * Implementation of queue using an array
 */
public class ArrayQueue {

    int front, rear, size;
    int capacity;
    int array[];

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }


    boolean isFull() {
        return (size == capacity);
    }


    boolean isEmpty() {
        return size == 0;
    }


    void enqueue(int item) {
        if (isFull())
            return;

        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }


    int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }


    int front() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }


    int rear() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() + " dequeued from queue\n");

        System.out.println("Front item is " + queue.front());

        System.out.println("Rear item is " + queue.rear());
    }
}
