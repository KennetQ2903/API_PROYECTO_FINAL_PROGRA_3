package Classes;

import java.util.ArrayList;
import java.util.List;

public class DeliveryList {
    private Node head;
    private int size;

    public void add(Delivery delivery) {
        Node newNode = new Node(delivery);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Delivery completeDelivery(int deliveryID) {
        Node current = head;
        while (current != null) {
            if (current.getDelivery().getID() == deliveryID) {
                current.getDelivery().setEstado("Completado");
                return current.getDelivery();
            }
            current = current.getNext();
        }
        return null;
    }
    public void remove(Delivery delivery) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.getDelivery().equals(delivery)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getDelivery());
            current = current.getNext();
        }
    }

    public List<Delivery> getAllDeliverys(){
        List<Delivery> deliverys = new ArrayList<>();
        Node current = head;
        while (current != null) {
            deliverys.add(current.getDelivery());
            current = current.getNext();
        }
        return deliverys;
    }

    private class Node {
        private Delivery delivery;
        private Node next;

        public Node(Delivery delivery) {
            this.delivery = delivery;
        }

        public Delivery getDelivery() {
            return delivery;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

