package dataStructureAndAlgo.Lecure8.assignment;

import java.util.ArrayList;

import static dataStructureAndAlgo.Lecure8.assignment.FindNode.print;
import static dataStructureAndAlgo.Lecure8.assignment.FindNode.takeInput;

/*
Question : Palindrome Linked List
Problem statement
You have been given a head to a singly linked list of integers.
Write a function check to whether the list given is a 'Palindrome' or not.

Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the given list is not a palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(Node<Integer> head) {
        Node<Integer> node = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (node!=null)
        {
            arr.add(node.data);
            node=node.next;
        }
        int start=0, end=arr.size()-1;
        while(start<end)
        {
            if (arr.get(start)!=arr.get(end))
            {
                return false;
            }
            else
            {
                start=start+1;
                end=end-1;
            }
        }

        return true;
    }
}
