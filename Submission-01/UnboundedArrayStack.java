package dsa_ca3;

public class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public UnboundedArrayStack() {
        capacity = 2;
        stack = new int[capacity];
        top = -1;
    }

    // Resize the array
    private void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        capacity = newCapacity;

        System.out.println("Array resized to: " + capacity);
    }

    // Push operation
    public void push(int value) {

        if (top == capacity - 1) {
            resize(capacity * 2);
        }

        stack[++top] = value;

        System.out.println(value + " pushed into Stack");
    }

    // Pop operation
    public int pop() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        int poppedValue = stack[top];
        top--;

        System.out.println(poppedValue + " popped from Stack");

        if (capacity > 2 && top + 1 <= capacity / 4) {
            resize(capacity / 2);
        }

        return poppedValue;
    }

    // Peek operation
    public int peek() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return stack[top];
    }

    // Check whether Stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Display Stack elements
    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.print("Stack elements: ");

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        System.out.println("Top element: " + stack.peek());
    }
}
