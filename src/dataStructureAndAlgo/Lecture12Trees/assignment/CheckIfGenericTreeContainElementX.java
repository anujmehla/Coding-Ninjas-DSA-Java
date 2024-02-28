package dataStructureAndAlgo.Lecture12Trees.assignment;

import dataStructureAndAlgo.Lecture11Queues.QueueUsingLL;
import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;

import java.util.ArrayList;
import java.util.Scanner;

/*
Problem : Check if generic tree contains x
Problem statement
Given a generic tree and an integer x, check if x is present in the given tree or not.
Return true if x is present, return false otherwise.

Input format :

Line 1 : Integer x

Line 2 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : true or false

Sample Input 1 :
40
10 3 20 30 40 2 40 50 0 0 0 0
 Sample Output 1 :
true
Explanation
Since, 40 is present in the given tree, so the answer will be true.
Sample Input 2 :
4
10 3 20 30 40 2 40 50 0 0 0 0
 Sample Output 2:
false
Explanation
Since, 4 is not present in the given tree, so the answer is false.
 */
class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;
    TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
}
public class CheckIfGenericTreeContainElementX {
    public static void main(String[] args) {
        //5 1 3 2 3 4 1 6 1 5 1 7 0 0 1 8 0
        TreeNode<Integer> root = takeInput();
        System.out.println(checkIfContainsX(root,5));
    }
    //my solution
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        boolean ans = false;
        for (int i = 0; i < root.children.size(); i++) {
            ans = checkIfContainsX(root.children.get(i),x);
            if (ans) return true;
        }
        return false;
    }
    //their solution
    public static boolean checkIfContainsX1(TreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        for (TreeNode<Integer> child : root.children) {
            if (checkIfContainsX1(child, x)) {
                return true;
            }
        }
        return false;
    }
    public static TreeNode<Integer> takeInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = scanner.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter num of children of " + frontNode.data);
                int numChildren = scanner.nextInt();
                for (int i = 0; i < numChildren; i++) {
                    System.out.println("Enter "+(i+1)+"th child of "+frontNode.data);
                    int child = scanner.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    frontNode.children.add(childNode);
                    pendingNodes.enqueue(childNode);
                }
            } catch (QueueEmptyException e) {
                //Shouldn't come here
                return null;
            }
        }
        return root;
    }
}
