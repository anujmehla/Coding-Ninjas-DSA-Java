package dataStructureAndAlgo.Lecture11Queues;

import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;
import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueFullException;

public class QueueUse {
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();
        for (int i = 0; i <= 5; i++) {
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {

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
