package dataStructuresAndAlgorithms.Lecture8LinkedList1.lecture;

/*
Question : What will be the output ?
 */

class Node<T> {
    int data;
    Node<T> next;
    Node(int data) {
        this.data = data;
//        this.next = null;
    }
}
public class ProblemStatement {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(10);
        Node<Integer> node2 = new Node<Integer>(20);
        node2.next = node1;
        print(node2);
    }
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp!=null) {
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
/*
Solution : The correct output is 20 10 because the code creates the linked list with two nodes, node2 and node1,
and sets node2 as the head. The code then prints the data value form head to tail.
 */