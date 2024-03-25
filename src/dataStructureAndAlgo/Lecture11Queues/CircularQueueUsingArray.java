package dataStructureAndAlgo.Lecture11Queues;

//incomplete implementation
public class CircularQueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    CircularQueueUsingArray() {
        data = null;
        front = -1;
        rear = -1;
    }
    CircularQueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }
    int size() {
        return size;
    }
    int front() {
        return data[front];
    }

    void enqueue(int element) {
        if (size == data.length) {
            throw new RuntimeException("Queue is full");
        }
        if (front == -1) {
            front++;
        }
        data[rear++] = element;
        size++;
    }
    int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is Empty");
        }
        size--;
        front++;
        return 0;
    }
}
