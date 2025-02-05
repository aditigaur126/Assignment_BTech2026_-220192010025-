//program to insert ll elements,remove data by position or data and display 
package dsa.linkedlist;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

    class insertion {
        static void display(Node head) {
            if (head == null) {
                System.out.println("no element found");
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.next;
            }
        }

        static Node removeData(Node head, int data) {
            if (head == null) {
                return null;
            }
            if (head.data == data) {
                head = head.next;
                display(head);
                return head;
            }
            Node temp = head;
            Node samp = null;
            while (temp != null && temp.data != data) {
                samp = temp;
                temp = temp.next;
            }
            int key = temp.data;
            samp.next = temp.next;
            System.out.println("Element removed : " + key);
            System.out.println("new ll :");
            display(head);
            return head;

        }

        static int nodeCount(Node head) {
            int count = 0;
            Node curr = head;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            return count;
        }

        static Node removeNode(Node head, int pos) {
            if (head == null) {
                return null;
            }
            if (pos == 1) {
                head = head.next;
                display(head);
                return head;
            }
            Node temp = head;
            Node prev = null;
            for (int i = 1; temp != null && i < pos; i++) {
                prev = temp;
                temp = temp.next;
            }
            System.out.println("element " + temp.data + " at " + pos + "removed");
            prev.next = temp.next;
            display(head);
            return head;

        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of nodes:");
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node curr = head;
            for (int i = 1; i < n; i++) {
                Node newNode = new Node(sc.nextInt());
                curr.next = newNode;
                curr = newNode;
            }
            display(head);
            System.out.println("enter an option ");
            System.out.println("1.remove data \n 2.remove a position");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Enter an element to remove:");
                    removeData(head, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter a position to remove:");
                    removeNode(head, sc.nextInt());
                    break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println("/nnumber of nodes in the linkelist: " + nodeCount(head));

            sc.close();
        }
    }
}
