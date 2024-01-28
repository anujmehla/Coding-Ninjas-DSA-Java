package dataStructureAndAlgo.Lecture8.lecture;


/*
Question : What will be the output ?
 */

public class ProblemStatement2 {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(10);
        Node<Integer> node2 = new Node<Integer>(20);
        Node<Integer> node3 = new Node<Integer>(30);
        Node<Integer> node4 = new Node<Integer>(40);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
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
solution : 20 30 40
 */