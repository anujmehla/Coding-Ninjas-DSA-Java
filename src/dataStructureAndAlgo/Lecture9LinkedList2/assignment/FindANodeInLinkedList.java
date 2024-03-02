package dataStructureAndAlgo.Lecture9LinkedList2.assignment;

import dataStructureAndAlgo.Lecture9LinkedList2.util.Node;

import java.util.LinkedList;

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
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(6);
        linkedList.add(1);
        linkedList.add(9);


    }
    public static int findNodeRec(Node<Integer> head, int n) {
        return 0;
    }
}
