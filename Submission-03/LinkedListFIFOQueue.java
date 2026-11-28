public class LinkedListFIFOQueue {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Enqueue operation
    public void enqueue(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(data + " inserted into Queue");
    }

    // Dequeue operation
    public void dequeue() {

        if (front == null) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Removed: " + front.data);

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // Peek operation
    public void peek() {

        if (front == null) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Front element: " + front.data);
    }

    // Check whether Queue is Empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display Queue elements
    public void display() {

        if (front == null) {
            System.out.println("Queue is Empty");
            return;
        }

        Node current = front;

        System.out.print("Queue elements: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.peek();

        queue.dequeue();
        queue.dequeue();

        queue.peek();

        queue.display();
    }
}
