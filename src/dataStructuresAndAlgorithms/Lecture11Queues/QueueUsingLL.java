package dataStructuresAndAlgorithms.Lecture11Queues;

import dataStructuresAndAlgorithms.Lecture11Queues.exceptions.QueueEmptyException;
import dataStructuresAndAlgorithms.Lecture9LinkedList2.util.Node;

public class QueueUsingLL<T> {
    private Node<T> rear;
    private Node<T> front;
    int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return front.data;
    }

    public void enqueue(T value) {
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

    public T dequeue() throws QueueEmptyException {
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
