package edu.pja.mas.dkucharski.datastructures;

public class CyclicalLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Make it cyclical
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain cyclical nature
        }
    }

    public void display() {
        if (head == null) return;

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
