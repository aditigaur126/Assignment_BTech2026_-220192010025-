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

public class BTree {
    Node root;

    // bfs-----------using queue
    Node buildTree(int[] a) {
        Queue<Node> q = new LinkedList<>();
        if (a.length == 0 || a[0] == -1) {
            return null;
        }

        root = new Node(a[0]);
        q.add(root); // q.offer(root);
        int i = 1;
        while (i < a.length) {
            Node cur = q.poll(); // the front element of q is current element now
            if (i < a.length && a[i] != -1) {
                cur.left = new Node(a[i]); // left child of cur node
                q.add(cur.left);
            }
            i++;

            if (i < a.length && a[i] != -1) {
                cur.right = new Node(a[i]); // right child of cur node
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    void print(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.data + " ");

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);

        }
    }

    int count(Node root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        return left + right + 1;
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.data;
    }

    int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;
        return Math.max(diam3, Math.max(diam2, diam1));
    }

    boolean identical(Node r1, Node r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.data != r2.data) {
            return false;

        }
        return identical(r1.left, r2.left) && identical(r1.right, r2.right);
    }

    boolean subtree(Node r1, Node r2) {
        if (r2 == null) { // subtree
            return true;
        }
        if (r1 == null) {
            return false;
        }
        if (r1.data == r2.data) {
            return identical(r1, r2);
        }
        return subtree(r1.left, r2) || subtree(r1.right, r2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree b = new BTree();
        System.out.println("enter no. of nodes:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        b.root = b.buildTree(a);
        b.print(b.root); // level order traversal
        System.out.println(b.count(b.root));
        System.out.println(b.sum(b.root));
        System.out.println(b.height(b.root));
        System.out.println(b.diameter(b.root));
        System.out.println("enter other tree no of nodes");
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }
        Node root2 = b.buildTree(a2);
        if (b.subtree(b.root, root2)) {
            System.out.println("subroot");
        } else {
            System.out.println("not a subroot");
        }
        sc.close();
    }
}
