package dataStructureAndAlgo.Lecture12Trees.lecture;

import dataStructureAndAlgo.Lecture11Queues.QueueUsingLL;
import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;

import java.util.Scanner;

public class TreeUse {
    public static void main(String[] args) {

        TreeNode<Integer> root = takeInputLevelWise();
        printLevelWise2(root);
        System.out.println("Number of nodes are " + numNode(root));
        System.out.println("Sum of nodes is " + sumOfAllNodes(root));
        System.out.println("Largest node in the tree is " + largestNode(root));
        System.out.println("Nodes greater than x are " + numNodeGreater(root, 5));
        System.out.println("Height of the tree is " + getHeight1(root));
        int k = 2;
        System.out.println("Nodes at depth "+k+" are ");
        printAtK(root,2);
        System.out.println("Number of leaf nodes in a tree are " + numberOfLeafNodes(root));
        System.out.println("Pre Order Traversal is ");
        preOrder(root);
        System.out.println("\nPost Order Traversal is ");
        printPostOrder(root);

//        printAtK(root,2);

//        print(root);

//        Scanner scanner = new Scanner(System.in);
//        TreeNode<Integer> root = takeInput(scanner);
//        print(root);

//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>(5);
//        TreeNode<Integer> node4 = new TreeNode<>(6);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);

//        System.out.println(root);
    }
    public static TreeNode<Integer> takeInput(Scanner scanner) {
        int n;
        System.out.println("Enter next node data ");
        n = scanner.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter number of children for " + n);
        int childCount = scanner.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(scanner);
            root.children.add(child);
        }
        return root;
    }
    public static void print(TreeNode<Integer> root) {
        String s = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ", ";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
    }

    public static TreeNode<Integer> takeInputLevelWise() {
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
    public static void printLevelWise(TreeNode<Integer> root) {
        System.out.println(root.data);
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                for (int i = 0; i < frontNode.children.size(); i++) {
                    System.out.print(frontNode.children.get(i).data+" ");
                    pendingNodes.enqueue(frontNode.children.get(i));
                }
                System.out.println();
            } catch (QueueEmptyException e) {
//                shouldn't reach here
//                throw new RuntimeException(e);
            }
        }
    }
    //chatgpt
    public static void printLevelWise1(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);

        while (!pendingNodes.isEmpty()) {
            int levelSize = pendingNodes.size();

            for (int i = 0; i < levelSize; i++) {
                try {
                    TreeNode<Integer> currentNode = pendingNodes.dequeue();
                    System.out.print(currentNode.data+ " ");

                    for (TreeNode<Integer> child : currentNode.children) {
                        pendingNodes.enqueue(child);
                    }
                } catch (QueueEmptyException e) {
//                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }
    }

    //their solution
    public static void printLevelWise2(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
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

            }
            if (temp == nullNode) {
                q.enqueue(nullNode);
                System.out.println();
                continue;
            }
            for (int i = 0; i < temp.children.size(); i++) {
                System.out.print(temp.children.get(i).data+" ");
                q.enqueue(temp.children.get(i));
            }
        }
    }

    public static int numNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += numNode(root.children.get(i));
        }
        return count;
    }

    public static int sumOfAllNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum += sumOfAllNode(root.children.get(i));
        }
        return sum;
    }

    //their solution
    public static int sumOfAllNodes(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int total = 0;
        for (int i = 0; i < root.children.size(); i++) {
            total += sumOfAllNodes(root.children.get(i));
        }
        return root.data+total;
    }
    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int ans = 0;
        if (root.data > x) {
            ans++;
        }
        for (int i = 0; i < root.children.size(); i++) {
            ans += numNodeGreater(root.children.get(i),x);
        }
        return ans;
    }
    //their solution
    public static int numNodeGreater1(TreeNode<Integer> root, int x) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        if (root.data > x) {
            count++;
        }
        for (TreeNode<Integer> child : root.children) {
            count = count + numNodeGreater1(child,x);
        }
        return count;
    }
    //assuming single node has a height of one and null node height equals to zero
    //chatgpt
    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int maxHeight = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childHeight = getHeight(root.children.get(i));
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight+1;
    }
    //their solution
    public static int getHeight1(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        for (TreeNode<Integer> child : root.children) {
            int childHeight = getHeight1(child);
            if (childHeight > ans) {
                ans = childHeight;
            }
        }
        return ans+1;
    }
    public static void  printAtK(TreeNode<Integer> root, int k) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printAtK(root.children.get(i),k-1);
        }
    }

    private static int numberOfLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.children.isEmpty()) {
            ans++;
        }
        for (TreeNode<Integer> child : root.children) {
            ans += numberOfLeafNodes(child);
        }
        return ans;
    }

    public static void preOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i));
        }
    }
    public static void printPostOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data+" ");
    }

    public static int largestNode(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int ans = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int childLargest = largestNode(root.children.get(i));
            if (childLargest > ans) {
                ans = childLargest;
            }
        }
        return ans;
    }
}
/*
Tree :
1:2,3
2:4,5
3:6,7
4:
5:
6:
7:

Level Order Traversal : for this we will use queue
output : 1 2 3 4 5 6 7
Pre Order Traversal: first root will be printed and its children will be printed, and it will form left to right
output : 1,2,4,5,3,6,7
Post Order Traversal: root will be printed after, first children will be printed in left to right order
output : 4 5 2 6 7 3 1
 */