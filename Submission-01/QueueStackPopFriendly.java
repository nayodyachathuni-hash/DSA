package dsa_ca3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int value) {

        // Add new value to queue2
        queue2.offer(value);

        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        System.out.println(value + " pushed into Stack");
    }

    // Pop operation
    public int pop() {

        if (queue1.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return queue1.poll();
    }

    // Peek operation
    public int peek() {

        if (queue1.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return queue1.peek();
    }

    // Check whether Stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Main method
    public static void main(String[] args) {

        QueueStackPopFriendly stack = new QueueStackPopFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Top element: " + stack.peek());
    }
}
