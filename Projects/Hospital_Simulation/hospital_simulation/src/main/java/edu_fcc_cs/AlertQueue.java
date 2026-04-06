package edu_fcc_cs;

public class AlertQueue {
    private class Node {
        Alert alert;
        Node next;

        Node(Alert a) {
            alert = a;
            next = null;
        }
    }

    private Node head, tail;

    public void enqueue(Alert a) {

        Node n = new Node(a);

        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public Alert dequeue() {

        if (head == null)
            return null;

        Alert a = head.alert;
        head = head.next;

        if (head == null)
            tail = null;

        return a;
    }

    public int count() {
        int c = 0;
        Node cur = head;

        while (cur != null) {
            c++;
            cur = cur.next;
        }

        return c;
    }
}
