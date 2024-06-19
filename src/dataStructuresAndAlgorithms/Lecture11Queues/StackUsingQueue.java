package dataStructuresAndAlgorithms.Lecture11Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue<T> {
    Queue<Integer> q1;
    Queue<Integer> q2;
    StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
}
