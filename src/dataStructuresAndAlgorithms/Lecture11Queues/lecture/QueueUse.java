package dataStructuresAndAlgorithms.Lecture11Queues.lecture;

import dataStructuresAndAlgorithms.Lecture11Queues.exceptions.QueueEmptyException;
import dataStructuresAndAlgorithms.Lecture11Queues.exceptions.QueueFullException;

public class QueueUse {
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(3);
//        QueueUsingLL<Integer> queue = new QueueUsingLL<>();
        for (int i = 1; i <= 5; i++) {
//            queue.enqueue(i);
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
                System.out.println("Queue is full");
            }
        }
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
