import java.util.Stack;

public class StackQueueDequeueFriendly {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation - O(n)
    public void enqueue(int value) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        System.out.println(value + " added to Queue");
    }

    // Dequeue operation - O(1)
    public int dequeue() {

        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = stack1.pop();

        System.out.println("Dequeued: " + value);

        return value;
    }

    // Peek operation - O(1)
    public int peek() {

        if (stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue =
                new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        queue.dequeue();
        queue.dequeue();

        System.out.println("Front element: " + queue.peek());
    }
}
