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
            next = curr.next; // to store the location of curr next
            curr.next = prev; // to reverse (arrow ulta<-)
            prev = curr; // backwards (ek step back->)
            curr = next; // now the stored value will be reversed(ek step back->)
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

    static Node swapinkpairs(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node cur = head;
        Node prev = dummy;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        while (count >= k) {
            cur = prev.next;
            Node next = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            count -= k;
        }
        return dummy.next;
    }

    static Node reverseInPair(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node sec = prev.next.next;
            first.next = sec.next;
            sec.next = first;
            prev.next = sec;
            prev = first;
        }
        return dummy.next;
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
        System.out.println();

        Node h2 = reverseInPair(head);
        display(h2);
        sc.close();

    }
}
