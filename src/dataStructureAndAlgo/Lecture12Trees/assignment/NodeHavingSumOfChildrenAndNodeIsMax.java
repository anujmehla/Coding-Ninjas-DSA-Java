package dataStructureAndAlgo.Lecture12Trees.assignment;

import dataStructureAndAlgo.Lecture11Queues.QueueUsingLL;
import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;

import java.util.Scanner;

/*
Problem : Node having sum of children and node is max
Problem statement
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum.
In the sum, data of node itself and data of immediate children is to be taken.

Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Representation of input


Sample Output 1 :
1
Explanation
Sum of node 1 and it's child (15) is maximum among all the nodes, so the output for this is 1.

 */
public class NodeHavingSumOfChildrenAndNodeIsMax {
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        print(root);
        System.out.println(maxSumNode(root).data);
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
                System.out.println("Enter the number of children of " + frontNode.data);
                int numChildren = scanner.nextInt();
                for (int i = 0; i < numChildren; i++) {
                    System.out.println("Enter the " + (i + 1) + "th child of " + frontNode.data);
                    int child = scanner.nextInt();
                    TreeNode<Integer> children = new TreeNode<>(child);
                    frontNode.children.add(children);
                    pendingNodes.enqueue(children);
                }
            } catch (QueueEmptyException e) {
                //will not reach here
            }
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {
        if (root == null) return;
        QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<>();
        TreeNode<Integer> nullNode = new TreeNode<>(Integer.MIN_VALUE);
        q.enqueue(root);
        q.enqueue(nullNode);
        System.out.println(root.data);
        while (q.size() != 1) {
            TreeNode<Integer> temp = null;
            try {
                temp = q.dequeue();
            } catch (QueueEmptyException qee) {
                //it won't reach here
            }
            if (temp == nullNode) {
                q.enqueue(nullNode);
                System.out.println();
                continue;
            }
            for (int i = 0; i < temp.children.size(); i++) {
                System.out.println(temp.children.get(i).data + " ");
                q.enqueue(temp.children.get(i));
            }
        }
    }
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {

        return null;
    }
}
