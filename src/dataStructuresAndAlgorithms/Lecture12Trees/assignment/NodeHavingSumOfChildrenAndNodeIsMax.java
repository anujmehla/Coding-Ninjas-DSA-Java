package dataStructuresAndAlgorithms.Lecture12Trees.assignment;

import dataStructuresAndAlgorithms.Lecture11Queues.QueueUsingLL;
import dataStructuresAndAlgorithms.Lecture11Queues.exceptions.QueueEmptyException;
import dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
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
        //5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
        TreeNode<Integer> root = takeInput();  //1 3 2 3 4 1 6 1 5 1 7 0 0 1 8 0
        print(root);
        System.out.println("The maxNode is ");
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
        if (root == null) return null;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode<Integer> maxNode = root;
        int maxSum = root.data;

        while (!queue.isEmpty()) {
            TreeNode<Integer> current = queue.poll();
            int currentSum = current.data; // Start sum with the node's own data
            for (TreeNode<Integer> child : current.children) {
                currentSum += child.data;
                queue.offer(child);
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxNode = current;
            }
        }
        return maxNode;
    }

    //their solution
    static class MaxNodePair<T> {
        TreeNode<T> node;
        int sum;
    }

    public static TreeNode<Integer> maxSumNode2(TreeNode<Integer> root) {
        return maxSumNodeHelper(root).node;
    }

    public static MaxNodePair<Integer> maxSumNodeHelper(TreeNode<Integer> root) {
        if (root == null) {
            MaxNodePair<Integer> pair = new MaxNodePair<>();
            pair.node = null;
            pair.sum = Integer.MIN_VALUE;
            return pair;
        }
        int sum = root.data;
        for (TreeNode<Integer> child : root.children) {
            sum += child.data;
        }
        MaxNodePair<Integer> ans = new MaxNodePair<>();
        ans.node = root;
        ans.sum = sum;
        for (TreeNode<Integer> child : root.children) {
            MaxNodePair<Integer> childAns = maxSumNodeHelper(child);
            if (childAns.sum > ans.sum) {
                ans = childAns;
            }
        }
        return ans;
    }
}
