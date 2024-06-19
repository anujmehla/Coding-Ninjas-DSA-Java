package dataStructuresAndAlgorithms.Lecture12Trees.assignment;

import dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeNode;

import static dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeUse.print;
import static dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeUse.takeInputLevelWise;

/*
Problem : Second-Largest Element In Tree
Given a generic tree, find and return the node with second-largest value in given tree.
Return NULL if no node with required value is present.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
40
 */
public class SecondLargestElementInTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise(); //10 3 20 30 40 2 40 50 0 0 0 0
        print(root);
        System.out.println("Second Largest Node is : "+findSecondLargest(root).data);
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        return findSecondLargestHelper(root).second;
    }

    public static Pair<TreeNode<Integer>> findSecondLargestHelper(TreeNode<Integer> root) {
        Pair<TreeNode<Integer>> output;
        if (root == null) {
            output = new Pair<TreeNode<Integer>>(root,null);
            return output;
        }
        output = new Pair<>(root, null);
        for (TreeNode<Integer> child : root.children) {
            Pair<TreeNode<Integer>> childPair = findSecondLargestHelper(child);
            if (childPair.first.data > output.first.data) {
                if (childPair.second == null || childPair.second.data < output.first.data) {
                    output.second = output.first;
                    output.first = childPair.first;
                } else {
                    output.first = childPair.first;
                    output.second = childPair.second;
                }
            } else if (childPair.first.data.equals(output.first.data) && childPair.second != null) {
                if (output.second == null || childPair.second.data > output.second.data) {
                    output.second = childPair.second;
                }
            } else if (output.first.data != childPair.first.data && (output.second == null || childPair.first.data > output.second.data)) {
                output.second = childPair.first;
            }
        }
        return output;
    }
    static class Pair<T> {
        T first;
        T second;

        Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }
}
