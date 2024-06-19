package dataStructuresAndAlgorithms.Lecture9LinkedList2;

import dataStructuresAndAlgorithms.Lecture9LinkedList2.util.Node;

import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.print;
import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.takeInput;

/*
Problem statement
You have been given a singly linked list of integers along with two integers, 'i,' and 'j.'
Swap the nodes that are present at the 'i-th' and 'j-th' positions and return the new head to the list.

Note :
1. Remember, You need to swap the nodes, not only the data.
2. Indexing starts from 0.
3. No need to print the list, it has already been taken care.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M
0 <= j < M

Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9
 Sample Input 2 :
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
 Sample Output 2 :
10 30 20 40
90 80 90 25 65 85 70
 */
public class SwapTwoNodesOfLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = takeInput(); //3 4 5 2 6 1 9 -1
        print(head);
        print(swapNodes(head, 0, 2)); //3 4 5 6 2 1 9
    }

    //my solution
    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        if (head == null) {
            return head;
        }
        Node<Integer> current1 = head;
        Node<Integer> current2 = head;
        Node<Integer> previous1 = head;
        Node<Integer> previous2 = head;
        if (i == j) {
            return head;
        } else if (i - j == 1) {
            Node<Integer> currentNode = head;
            int count = 0;
            while (currentNode != null) {
                count++;
                currentNode = currentNode.next;
                Node<Integer> temp = null;
                if (count == i - 1) {
                    temp = currentNode.next;
                    currentNode.next = currentNode.next.next;
                    Node<Integer> temp2 = currentNode.next.next;
                    currentNode.next.next = temp;
                    temp.next = temp2;
                }
            }
        } else if (i == 0) {
            for (int k = 0; k < j; k++) {
                previous2 = current2;
                current2 = current2.next;
            }
            previous1 = null;
            Node<Integer> temp = current2.next;
            current2.next = current1.next;
            current1.next = temp;
            previous2.next = current1;
            return current2;
        } else {
            for (int k = 0; k < i; k++) {
                previous1 = current1;
                current1 = current1.next;
            }
            for (int k = 0; k < j; k++) {
                previous2 = current2;
                current2 = current2.next;
            }
            previous1.next = current2;
            previous2.next = current1;
            Node<Integer> temp = current1.next;
            current1.next = current2.next;
            current2.next = temp;
        }
        return head;
    }

    //their solution
    public static Node<Integer> swapNodes2(Node<Integer> head, int i, int j) {
        if (i == j) {
            return head;
        }
        Node<Integer> currentNode = head;
        Node<Integer> prev = null;
        Node<Integer> firstNode = null;
        Node<Integer> secondNode = null;
        Node<Integer> firstNodePrev = null;
        Node<Integer> secondNodePrev = null;
        int pos = 0;
        while (currentNode != null) {
            if (pos == 1) {
                firstNodePrev = prev;
                firstNode = currentNode;
            } else if (pos == j) {
                secondNodePrev = prev;
                secondNode = currentNode;
            }
            prev = currentNode;
            currentNode = currentNode.next;
            pos+=1;
        }
        if (firstNodePrev != null) {
            firstNodePrev.next = secondNode;
        } else {
            head = secondNode;
        }
        if (secondNodePrev != null) {
            secondNodePrev.next = firstNode;
        } else {
            head = firstNode;
        }
        Node<Integer> currentFirstNode = secondNode.next;
        secondNode.next = firstNode.next;
        firstNode.next = currentFirstNode;
        return head;
    }
}
