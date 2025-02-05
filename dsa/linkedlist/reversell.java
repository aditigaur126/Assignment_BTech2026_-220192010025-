package dsa.linkedlist;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class reversell {
    static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;// to store the location of curr next
            curr.next = prev;// to reverse (arrow ulta<-)
            prev = curr;// backwards (ek step back->)
            curr = next;// now the stored value will be reversed(ek step back->)
        }
        return prev;

    }

    static void display(Node head) {
        if (head == null) {
            System.out.println("empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of nodes: ");
        int n = sc.nextInt();
        Node head = new Node(sc.nextInt());
        Node curr = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            curr.next = newNode;
            curr = newNode;

        }
        System.out.println("Before reversal :");
        display(head);
        head = reverse(head);
        System.out.println("\nAfter reversal :");
        display(head);
        sc.close();

    }
}
