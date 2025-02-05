package dsa.tree;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

}

public class BinarySearchTree {
    Node root;

    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        return (root.data < data) ? search(root.right, data) : search(root.left, data);
    }

    Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data < data) {
            root.right = delete(root.right, data);
        } else if (root.data > data) {
            root.left = delete(root.left, data);
        } else {
            // with 1 or 0 children
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // with 2 children so inorder successor min from root.right
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);

        }
        return root;
    }

    int minValue(Node root) {
        if (root == null) {
            return -1;
        }
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data + " ");

            inorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {

            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no. of nodes");
        int n = sc.nextInt();

        b.root = b.insert(b.root, 50);
        for (int i = 1; i < n; i++) {
            b.insert(b.root, sc.nextInt());
        }
        System.out.println("Inorder traversal:");
        b.inorder(b.root);
        System.out.println();

        // Search operation
        int key = 40;
        System.out.println("Search " + key + ": " + (b.search(b.root, key) ? "Found" : "Not Found"));

        // Delete operation
        b.root = b.delete(b.root, 40);
        System.out.println("Inorder traversal after deleting 40:");
        b.inorder(b.root);
        sc.close();
    }
}
