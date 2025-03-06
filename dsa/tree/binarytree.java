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

public class binarytree {

    Node root;

    // dfs insertion ---------- recursion
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data == -1) {
            return null;
        }
        if (root.left == null) {
            root.left = insert(root.left, data);
        } else if (root.left != null && root.right == null) {
            root.right = insert(root.right, data);
        } else {
            insert(root.left, data);
        }
        return root;
    }

    public static void main(String[] args) {
        binarytree b = new binarytree();
        System.out.println("Enter no. of nodes:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        b.root = b.insert(b.root, sc.nextInt());
        for (int i = 1; i < n; i++) {
            b.insert(b.root, sc.nextInt());
        }
        b.print(b.root);
        System.out.println();
        ArrayList<Integer> path = new ArrayList<>();
        b.paths(b.root, path);
        sc.close();
    }

    void print(Node root) { // Inorder traversal
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " "); // Fixed print format
            print(root.right);
        }
    }

    void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(Node root) {
        if (root == null) {
            return;
        }

        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data + " ");
    }

    void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
        System.out.println();
    }

    void paths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            paths(root.left, path);
            paths(root.right, path);

        }
        path.remove(path.size() - 1);
    }

}
