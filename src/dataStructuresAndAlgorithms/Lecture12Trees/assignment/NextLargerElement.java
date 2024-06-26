package dataStructuresAndAlgorithms.Lecture12Trees.assignment;

import dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeNode;

import static dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeUse.print;
import static dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeUse.takeInputLevelWise;

/*
Problem : Next larger element
Problem statement
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e.
find a node with value just greater than n.


Return NULL if no node is present with value greater than n.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
18
10 3 20 30 40 2 40 50 0 0 0 0
Representation of Input


Sample Output 1 :
20
Explanation
In the given tree, the value which is just greater than 18 is 20.
Sample Input 2 :
21
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 2:
30
*/
public class NextLargerElement {
    public static void main(String[] args) {
        TreeNode<Integer> root = takeInputLevelWise(); // 10 3 20 30 40 2 40 50 0 0 0 0
//        1 2 2 3 3 4 5 6 2 7 8 0 0 1 9 1 12 0 0 0
        print(root);
        int n = 4;
        System.out.println("Node larger than "+n+" is : "+findNextLargerNode(root, n).data);
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> nextLargerNode = null;
        if (root.data > n) {
            nextLargerNode = root;
        }
        for (TreeNode<Integer> child : root.children) {
            TreeNode<Integer> childLargerNode = findNextLargerNode(child,n);
            if (childLargerNode != null) {
                if (nextLargerNode == null || childLargerNode.data < nextLargerNode.data) {
                    nextLargerNode = childLargerNode;
                }
            }
        }
        return nextLargerNode;
    }
}


