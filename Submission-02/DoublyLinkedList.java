public class DoublyLinkedList {

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
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        System.out.println(data + " inserted at beginning");
    }

    // Insert at the end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
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

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println(data + " not found");
            return;
        }

        if (current == head) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        if (current == tail) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }

        System.out.println(data + " deleted");
    }

    // Display from beginning to end
    public void displayForward() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    // Display from end to beginning
    public void displayBackward() {

        if (tail == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }

    // Search for a value
    public boolean search(int data) {

        Node current = head;

        while (current != null) {

            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

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
