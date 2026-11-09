
package dsa_ca3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {

    // Create two Queues
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int value) {
        queue1.offer(value);
        System.out.println(value + " pushed into Stack");
    }

    // Pop operation
    public int pop() {

        if (queue1.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        // Move all elements except the last one
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        // Remove the last element
        int poppedValue = queue1.poll();

        // Swap the two queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedValue;
    }

    // Peek operation
    public int peek() {

        if (queue1.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }

        int topValue = queue1.peek();

        // Move the last element too
        queue2.offer(queue1.poll());

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topValue;
    }

    // Check whether Stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Main method
    public static void main(String[] args) {

        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Top element: " + stack.peek());
    }
}
