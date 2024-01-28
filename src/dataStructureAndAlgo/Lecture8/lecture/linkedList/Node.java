package dataStructureAndAlgo.Lecture8.lecture.linkedList;

public class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }
}
