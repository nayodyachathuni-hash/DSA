public class CircularDoublyLinkedList {

    // Node class
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Insert at the beginning
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;

            head.next = head;
            head.prev = head;

        } else {
            newNode.next = head;
            newNode.prev = tail;

            head.prev = newNode;
            tail.next = newNode;

            head = newNode;
        }

        System.out.println(data + " inserted at beginning");
    }

    // Insert at the end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;

            head.next = head;
            head.prev = head;

        } else {
            newNode.prev = tail;
            newNode.next = head;

            tail.next = newNode;
            head.prev = newNode;

            tail = newNode;
        }

        System.out.println(data + " inserted at end");
    }

    // Delete a node
    public void delete(int data) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;

        do {
            if (current.data == data) {

                if (head == tail) {
                    head = tail = null;

                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                    if (current == head) {
                        head = current.next;
                    }

                    if (current == tail) {
                        tail = current.prev;
                    }
                }

                System.out.println(data + " deleted");
                return;
            }

            current = current.next;

        } while (current != head);

        System.out.println(data + " not found");
    }

    // Display forward
    public void displayForward() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;

        System.out.print("Forward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.next;

        } while (current != head);

        System.out.println("(back to head)");
    }

    // Display backward
    public void displayBackward() {

        if (tail == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = tail;

        System.out.print("Backward: ");

        do {
            System.out.print(current.data + " <-> ");
            current = current.prev;

        } while (current != tail);

        System.out.println("(back to tail)");
    }

    // Search for a value
    public boolean search(int data) {

        if (head == null) {
            return false;
        }

        Node current = head;

        do {
            if (current.data == data) {
                return true;
            }

            current = current.next;

        } while (current != head);

        return false;
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.displayForward();
        list.displayBackward();

        list.insertAtBeginning(5);

        list.displayForward();

        list.delete(20);

        list.displayForward();
        list.displayBackward();

        System.out.println("Search 30: " + list.search(30));
        System.out.println("Search 50: " + list.search(50));
    }
}
