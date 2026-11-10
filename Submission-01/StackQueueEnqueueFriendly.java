package dsa_ca3;

import java.util.Stack;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int value) {

        stack1.push(value);

        System.out.println(value + " added to Queue");
    }

    // Dequeue operation
    public int dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek operation
    public int peek() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check whether Queue is empty
    public boolean isEmpty() {

        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Main method
    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
                new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Front element: " + queue.peek());
    }
}
