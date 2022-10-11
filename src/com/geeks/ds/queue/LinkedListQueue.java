package com.geeks.ds.queue;

/**
 * Implementation of queue using linked list
 */
public class LinkedListQueue {

    Node front;
    Node rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }


    void enqueue(int key) {
        Node temp = new Node(key);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }


     Node dequeue() {

        if (this.front == null)
            return null;

        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;

        return temp;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.dequeue();
        System.out.println("Queue Front : " + queue.front.key);
        System.out.println("Queue Rear : " + queue.rear.key);
    }
}

class Node {
    int key;
    Node next;


    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}
