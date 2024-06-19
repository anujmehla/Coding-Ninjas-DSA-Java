package dataStructuresAndAlgorithms.Lecture9LinkedList2.assignment;

import dataStructuresAndAlgorithms.Lecture9LinkedList2.util.Node;

import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.print;
import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.takeInput;

/*
Question - Delete every N nodes
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.'
Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes.
Continue the same until the end of the linked list. Indexing starts from 1.

To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
You can return null in case where all nodes will be deleted.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
Explanation of Sample Input 2 :
For the first query, we delete one node after every zero elements hence removing all the items of the list.
Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, resulting in the final list, 1 -> 2 -> 6 -> 7.
 */
public class DeleteEveryNNodes {
    public static void main(String[] args) {
        Node<Integer> head = takeInput(); //input : 1 2 3 4 5 6 7 8
        print(head);
        print(skipMdeleteN(head, 2, 2)); //expected : 1 2 5 6
    }

    // failed one test
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (head == null || N == 0) {
            return head;
        }
        Node<Integer> current = head;
        Node<Integer> temp = null;
        while (current != null) {
            int count = 1;
            while (count < M && current != null) {
                current = current.next;
                count++;
            }
            if (current == null) {
                break;
            }
            temp = current.next;
            count = 0;
            while (count < N && temp != null) {
                Node<Integer> toDelete = temp;
                temp = temp.next;
                count++;
            }
            current.next = temp;
            current = temp;
        }
        return head;
    }

    //their solution
    public static Node<Integer> skipMdeleteN2(Node<Integer> head, int M, int N) {
        if (M == 0 || head == null) {
            return null;
        }
        if (N == 0) {
            return head;
        }
        Node<Integer> currentNode = head;
        Node<Integer> temp = null;

        while (currentNode != null) {
            int take = 0;
            int skip = 0;

            while (currentNode != null && take < M) {
                if (temp == null) {
                    temp = currentNode;
                } else {
                    temp.next = currentNode;
                    temp = currentNode;
                }
                currentNode = currentNode.next;
                take += 1;
            }
            while (currentNode != null && skip < N) {
                currentNode = currentNode.next;
                skip += 1;
            }
        }
        if (temp != null) {
            temp.next = null;
        }
        return head;
    }
}
