package dataStructureAndAlgo.Lecture8.lecture;

import java.util.Scanner;

/*
Question : delete a node from Linked List
Problem statement
You have been given a linked list of integers.
Your task is to write a function that deletes a node from a given position, 'POS'.

Note :
Assume that the Indexing for the linked list always starts from 0.

If the position is greater than or equal to the length of the linked list,
you should return the same linked list without any change.
Illustration :
The following images depict how the deletion has been performed.
Image-I :

Alt txt

Image-II :

Alt txt

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Explanation of Sample Output 1 :
The data in the node with index 3 is 2 which has been removed.
Sample Input 2 :
3 4 5 2 6 1 9 -1
0
Sample Output 2 :
4 5 2 6 1 9
Constraints :
0 <= N <= 10^5
POS >= 0

Time Limit: 1sec
Expected Complexity :
Time Complexity  : O(N)
Space Complexity  : O(1)
 */
public class DeleteNode {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
//        print(head);
//        head = insert(head,2,80);
        print(head);
        System.out.println("After deleting a node");
        head = deleteNode(head,0);
        print(head);
    }
    private static Node<Integer> insert(Node<Integer> head, int position, int data) {
        Node<Integer> newNode = new Node<>(data);
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        int i = 0;
        Node<Integer> temp = head;
        while (i < position-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    private static Node<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
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
            data = s.nextInt();
        }
        return head;
    }

    private static void print(Node<Integer> head) {
        while (head!=null) {
            System.out.println(head.data+" ");
            head = head.next;
        }
    }
    private static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        if (head == null || pos < 0) {
            return head;
        }
        if (pos == 0 ) {
            return head.next;
        }
        Node<Integer> current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return head;
        }
        Node<Integer> temp = current.next;
        current.next = temp.next;
        temp = null; //it is a good practice to nullify it
        return head;
    }
}
