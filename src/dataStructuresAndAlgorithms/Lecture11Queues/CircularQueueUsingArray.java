package dataStructuresAndAlgorithms.Lecture11Queues;

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

    public int size() {
        return size;
    }

    public int front() {
        if (size == 0) {
            throw new RuntimeException("Queue is Empty");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {
        if (size == data.length) {
            throw new RuntimeException("Queue is full");
        }
        if (size == 0) {
            front = 0;
        }
//        rear++;
//        if (rear == data.length) {
//            rear = 0;
//        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is Empty");
        }
        int temp = data[front];
//        front++;
//        if (front == data.length) {
//            front = 0;
//        }
        front = (front + 1) % data.length;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }
    private void doubleCapacity() {
        //need to implement this
    }
}
