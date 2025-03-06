package dsa.tree;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class bst {
    Node root;

    Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    void print(Node root) { // inorder traversal
        if (root != null) {
            print(root.left);
            System.out.println(root.data + " ");
            print(root.right);
        }
    }

    static boolean searchSum(Node root, int sum) {
        if (root == null && sum == 0) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.data;
        }
        return searchSum(root.left, sum - root.data) || searchSum(root.right, sum - root.data);
    }

    public static void main(String[] args) {
        bst b = new bst();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of nodes:");
        int n = sc.nextInt();
        b.root = b.insert(b.root, 50);
        for (int i = 0; i < n - 1; i++) {
            b.insert(b.root, sc.nextInt());
        }
        b.print(b.root);
        System.out.println("enter sum:");
        String res = searchSum(b.root, sc.nextInt()) ? "yes" : "no";
        System.out.println(res);
        sc.close();

    }
}
