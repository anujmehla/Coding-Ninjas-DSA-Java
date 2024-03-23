package dataStructureAndAlgo.Lecture11Queues;

import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;
import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueFullException;

/*
time complexity of all the operations is O(1)
 */
public class QueueUsingArray {

    private int[] data;
    private int front; // index at which front element is stored
    private int rear; // index at which rear element is stored
    private int size;

    public QueueUsingArray() {
        data = new int[10];
        front = -1;
        rear = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    void enqueue(int element) throws QueueFullException {
        if (size() == data.length) {
            throw new QueueFullException();
        }
        if (size() == 0) {
            front = 0;
        }
        size++;
        rear = (rear + 1) % data.length;
//        rear++;
//        if (rear == data.length) {
//            rear = 0;
//        }
        data[rear] = element;
    }

    int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int temp = data[front];
        front = (front + 1) % data.length;
//        front++;
//        if (front == data.length) {
//            front = 0;
//        }
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }
}
