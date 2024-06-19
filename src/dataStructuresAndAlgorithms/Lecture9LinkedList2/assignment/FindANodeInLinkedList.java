package dataStructuresAndAlgorithms.Lecture9LinkedList2.assignment;

import dataStructuresAndAlgorithms.Lecture9LinkedList2.util.Node;

import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.print;
import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.takeInput;

/*
Problem : Find a Node in Linked List (recursive)
Given a singly linked list of integers and an integer n,
find and return the index for the first occurrence of 'n' in the linked list. -1 otherwise.

Follow a recursive approach to solve this.

Note :
Assume that the Indexing for the linked list always starts from 0.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit:  1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
100
Sample Output 1 :
-1
Sample Input 2 :
2
10 20010 30 400 600 -1
20010
100 200 300 400 9000 -34 -1
-34
Sample Output 2 :
1
5
 */
public class FindANodeInLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = takeInput(); //100 200 300 400 9000 -34 -1
        print(head);
        System.out.println("Index of element is "+findNodeRec(head,-34));
    }
    public static int findNodeRec(Node<Integer> head, int n) {
        if (head == null) {
            return -1;
        }
        if (head.data.equals(n)) {
            return 0;
        }
        int smallIndex = findNodeRec(head.next,n);
        if (smallIndex == -1) {
            return smallIndex;
        } else {
            return smallIndex+1;
        }
    }
}