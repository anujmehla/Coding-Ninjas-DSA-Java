package dataStructureAndAlgo.Lecture8.lecture.linkedList;

import java.util.Scanner;

public class LinkedListUse {
    private static void print(Node<Integer> head) {
        while (head != null) {
            System.out.println(head.data+" ");
            head = head.next;
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
                tail = newNode; //tail = tail.next
//                Node<Integer> temp = head;
//                while (temp.next!=null) {
//                    temp = temp.next;
//                }
//                temp.next = newNode;

            }
            data = s.nextInt();
        }
        return head;
    }
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = insert(head,80,0);
        print(head);
//        Node<Integer> node1 = new Node<>(10);
//        Node<Integer> node2 = new Node<>(20);
//        Node<Integer> node3 = new Node<>(30);
//        node1.next = node2;
//        node2.next = node3;
//        Node<Integer> head = node1;
//        print(head);

    }
    public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
        Node<Integer> newNode = new Node<>(data);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        int i = 0;
        Node<Integer> temp = head;
        while (i < pos-1) {
            temp = temp.next;
             i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
}