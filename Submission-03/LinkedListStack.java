public class LinkedListStack {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    // Push operation
    public void push(int data) {

        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        System.out.println(data + " pushed into Stack");
    }

    // Pop operation
    public void pop() {

        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Popped: " + top.data);

        top = top.next;
    }

    // Peek operation
    public void peek() {

        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Top element: " + top.data);
    }

    // Check whether Stack is Empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display Stack elements
    public void display() {

        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }

        Node current = top;

        System.out.print("Stack elements: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.peek();

        stack.pop();
        stack.pop();

        stack.peek();

        stack.display();
    }
}
