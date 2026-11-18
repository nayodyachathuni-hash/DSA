public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {

        if (size == capacity) {
            System.out.println("Queue is Full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        System.out.println(value + " added to Queue");
    }

    // Dequeue operation
    public int dequeue() {

        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = queue[front];

        front = (front + 1) % capacity;
        size--;

        System.out.println("Dequeued: " + value);

        return value;
    }

    // Peek operation
    public int peek() {

        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return queue[front];
    }

    // Display operation
    public void display() {

        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue elements: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        ArrayCircularQueue queue =
                new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        System.out.println("Front element: " + queue.peek());

        queue.dequeue();
        queue.dequeue();

        queue.display();

        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();

        System.out.println("Front element: " + queue.peek());
    }
}
