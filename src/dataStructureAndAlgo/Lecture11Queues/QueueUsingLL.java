package dataStructureAndAlgo.Lecture11Queues;

import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;
import dataStructureAndAlgo.Lecture9.util.Node;

public class QueueUsingLL<T> {
    private Node<T> rear;
    private Node<T> front;
    int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    T front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return front.data;
    }

    void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    T dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        T temp = front.data;
        front = front.next;
        if (size == 1) {
            rear = null;
        }
        size--;
        return temp;
    }
}
