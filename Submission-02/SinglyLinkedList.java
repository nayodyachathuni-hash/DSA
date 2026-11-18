public class SinglyLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert at the beginning
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        System.out.println(data + " inserted at beginning");
    }

    // Insert at the end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println(data + " inserted at end");
    }

    // Delete a node
    public void delete(int data) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted");
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println(data + " not found");
        } else {
            current.next = current.next.next;
            System.out.println(data + " deleted");
        }
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

    // Display the linked list
    public void display() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.display();

        list.insertAtBeginning(5);

        list.display();

        list.delete(20);

        list.display();

        System.out.println("Search 30: " + list.search(30));

        System.out.println("Search 50: " + list.search(50));
    }
}
