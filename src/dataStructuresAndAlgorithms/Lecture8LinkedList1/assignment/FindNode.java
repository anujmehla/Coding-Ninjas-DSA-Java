package dataStructuresAndAlgorithms.Lecture8LinkedList1.assignment;

import java.util.Scanner;

/*
Question : Find a node in Linked List
Problem statement
You have been given a singly linked list of integers.
Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.

Note :
Assume that the Indexing for the singly linked list always starts from 0.
Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= T <= 10^2
0 <= M <= 10^5

Where 'M' is the size of the singly linked list.

Time Limit: 1 sec
Sample Input 1 :
2
3 4 5 2 6 1 9 -1
5
10 20 30 40 50 60 70 -1
6
Sample Output 1 :
2
-1
 Explanation for Sample Output 1:
In test case 1, 'N' = 5 appears at position 2 (0-based indexing) in the given linked list.

In test case 2, we can see that 'N' = 6 is not present in the given linked list.
Sample Input 2 :
2
1 -1
2
3 4 5 2 6 1 9 -1
6
Sample Output 2 :
-1
4
 Explanation for Sample Output 2:
In test case 1, we can see that 'N' = 2 is not present in the given linked list.

In test case 2, 'N' = 6 appears at position 4 (0-based indexing) in the given linked list.
 */
class Node<T> {
    T data;
    Node<T> next;
    Node(T data) {
        this.data = data;
    }
}
public class FindNode {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        int n = 6;
        System.out.println("\nIndex of node is : "+findNode(head, n));
    }
    public static int findNode(Node<Integer> head, int n) {
        int pos = 0;
        while (head != null) {
            if (head.data.equals(n)) {
                return pos;
            }
            head = head.next;
            pos++;
        }
        return -1;
    }
    public static Node<Integer> takeInput() {
        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = input.nextInt();
        }
        return head;
    }
    public static void print(Node<Integer> head) {
        while (head!=null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}