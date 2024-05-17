package dataStructureAndAlgo.Lecture11Queues.assignment;

import java.util.LinkedList;
import java.util.Queue;

/*
Question : Reverse Queue
Problem statement
You have been given a queue that can store integers as the data.
You are required to write a function that reverses the populated queue itself without using any other data structures.

Example:
Alt txt

Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= t <= 100
1 <= N <= 10^4
-2^31 <= data <= 2^31 - 1

Time Limit: 1sec
Sample Input 1:
1
6
1 2 3 4 5 10
Note:
Here, 1 is at the front and 10 is at the rear of the queue.
Sample Output 1:
10 5 4 3 2 1
Sample Input 2:
2
5
2 8 15 1 10
3
10 20 30
Sample Output 2:
10 1 15 8 2
30 20 10
 */
public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(8);
        queue.add(15);
        queue.add(1);
        queue.add(10);
        reverseQueue(queue);
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            System.out.println(queue.remove());
        }
    }
//*note : image is available for this question in the image folder
    public static void reverseQueue(Queue<Integer> input) {
        if (input.size() <= 1) {
            return;
        }
        int front = input.poll();
        reverseQueue(input);
        input.add(front);
    }
}
