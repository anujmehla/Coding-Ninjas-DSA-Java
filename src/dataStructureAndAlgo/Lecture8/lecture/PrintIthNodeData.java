package dataStructureAndAlgo.Lecture8.lecture;

/*
Question : Print i-th Node Data
Problem statement
For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.

 Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line contains the value of 'i'. It denotes the position in the given singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence,
would never be a list element.
Output format :
For each test case, print the node data at the 'i-th' position of the linked list(if exists).

Output for every test case will be printed in a separate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
i  >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
2
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
9 8 4 0 7 8 -1
3
Sample Output 2 :
3
0
 */

import java.util.Scanner;

public class PrintIthNodeData {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        int position = 3;
        System.out.println("The answer is : ");
        printIthNode(head, position);
    }
//    my solution
    public static void printIthNode(Node<Integer> head, int i) {
        if (i==0) return;
        while (i > 0) {
            if (head == null) {
                //print nothing
                i--;
                return;
            } else {
                head = head.next;
                i--;
            }
        }
        System.out.println(head.data);
    }
//    their solution
    public static void printIthNode1(Node<Integer> head, int i) {
        int position = 0;
        Node<Integer> temp = head;
        while (temp != null && position < i) {
            temp = temp.next;
            position++;
        }
        if (temp != null) {
            System.out.println(temp.data);
        }
    }

    public static Node<Integer> takeInput() {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
}