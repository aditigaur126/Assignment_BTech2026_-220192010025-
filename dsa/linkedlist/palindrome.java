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

public class palindrome {
    /**
     * static boolean palindrome(Node head) {
     * if(head==null || head.next==null){
     * return true;
     * }
     * Node curr = head;
     * Stack<Integer> s = new Stack<>();
     * while (curr != null) {
     * s.push(curr.data);
     * curr = curr.next;
     * }
     * 
     * while (head != null) {
     * if (head.data != s
     * .pop()) {
     * return false;
     * }
     * head = head.next;
     * }
     * return true;
     * }
     **/
    static Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static boolean isIdentical(Node n1, Node n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;

        }
        return true;
    }

    static boolean palin(Node head) {

        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {// middle element
            slow = slow.next;
            fast = fast.next.next;
        }
        Node head2 = reverse(slow.next);
        boolean ret = isIdentical(head, head2);
        // head2=reverse(head2);
        // slow.next=head2;
        return ret;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("no.of nodes");
        int n = sc.nextInt();
        Node head = new Node(sc.nextInt());
        Node curr = head;
        for (int i = 1; i < n; i++) {
            Node nN = new Node(sc.nextInt());
            curr.next = nN;
            curr = nN;
        }
        if (palin(head)) {
            System.out.println("is palindrome");
        } else {
            System.out.println("not");
        }
        sc.close();
    }

}
