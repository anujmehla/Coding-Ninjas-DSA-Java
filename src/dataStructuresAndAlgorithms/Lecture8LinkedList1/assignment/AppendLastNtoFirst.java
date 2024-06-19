package dataStructuresAndAlgorithms.Lecture8LinkedList1.assignment;

import static dataStructuresAndAlgorithms.Lecture8LinkedList1.assignment.FindNode.print;
import static dataStructuresAndAlgorithms.Lecture8LinkedList1.assignment.FindNode.takeInput;

/*
Question : Append Last N to First
Problem statement
You have been given a singly linked list of integers along with an integer 'N'.
Write a function to append the last 'N' nodes towards the front of the singly linked list and
returns the new head to the list.

Hint:
Identify how many pointers you require and try traversing them to right places and connect nodes accordingly
also don't forget to disconnect what's required else it could create cycles.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
0 <= N < M
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence,
would never be a list element.
Sample Input 1 :
2
1 2 3 4 5 -1
3
10 20 30 40 50 60 -1
5
Sample Output 1 :
3 4 5 1 2
20 30 40 50 60 10
Sample Input 2 :
1
10 6 77 90 61 67 100 -1
4
Sample Output 2 :
90 61 67 100 10 6 77
 Explanation to Sample Input 2 :
We have been required to move the last 4 nodes to the front of the list. Here,
"90->61->67->100" is the list which represents the last 4 nodes.
When we move this list to the front then the remaining part of the initial list which is, "10->6->77" is attached
after 100. Hence, the new list formed with an updated head pointing to 90.
 */
public class AppendLastNtoFirst {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        int n = 3;
        head = appendLastNToFirst1(head, 3);
        System.out.println("\n After the changes :");
        print(head);
    }

    //my attempt - not working
    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
        Node<Integer> temp = head;
        int length = length(head);
        int position = length - n;
        while (position > 0) {
            temp = temp.next;
            position--;
        }
        Node<Integer> temp2 = temp;
        System.out.println("The current index is at " + temp.data);
        while (temp != null) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println("The current index is at " + temp.data);
        System.out.println("\nPrinting the elements :");
        Node<Integer> temp3 = temp;
        temp.next = head;
        while (length > 0) {
            System.out.println(temp2.data);
            temp2 = temp2.next;
            length--;
        }
        temp2.next = null;
        return temp3;
    }

    // their attempt
    public static Node<Integer> appendLastNToFirst1(Node<Integer> head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        //defining required three nodes
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        Node<Integer> initialHead = head;
        //moving fast node n positions forward
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //now moving fast and slow forward till fast node.next is not null
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //node next to slow is our head node
        Node<Integer> temp = slow.next;
        //breaking the previous bond : to break the cycle
        slow.next = null;
        //linking the last node to the first node
        fast.next = initialHead;
        head = temp;

        return head;
    }

    public static int length(Node<Integer> head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}