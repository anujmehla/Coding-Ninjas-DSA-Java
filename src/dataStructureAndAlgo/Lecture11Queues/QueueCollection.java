package dataStructureAndAlgo.Lecture11Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueCollection {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(5);
        queue.add(10);
        stack.push(10);
        stack.push(20);
        System.out.println(queue.peek() + stack.pop());

        //predict the output
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 1; i < 5; i++) {
//            queue.add(10+i);
//        }
//        System.out.println(queue.poll()+" "+queue.size());


        queue.add(10);
        queue.add(20);
//        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
