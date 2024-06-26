package dataStructuresAndAlgorithms.Lecture9LinkedList2.lecture;

import dataStructuresAndAlgorithms.Lecture9LinkedList2.util.Node;

import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.print;
import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.takeInput;

public class InsertRecursively {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = insert(head,0,10);
        print(head);
    }
    public static Node<Integer> insert(Node<Integer> head, int pos,int element) {
        if (pos == 0) {
            Node<Integer> newNode = new Node<>(element);
            newNode.next = head;
            return newNode;
        }
        if (head == null) {
            return head;
        }
        head.next = insert(head.next,pos-1,element);
        return head;
    }
}
