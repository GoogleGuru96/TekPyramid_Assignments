package DSAAssgmnt;

public class CircularQueue {

        private int[] arr;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void enqueue(int data) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot insert: " + data);
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = data;
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Nothing to remove.");
                return -1;
            }
            int removed = arr[front];
            front = (front + 1) % capacity;
            size--;
            return removed;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[front];
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }

            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {

            CircularQueue queue = new CircularQueue(5);

            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40);
            queue.enqueue(50);

            queue.display();

            queue.dequeue();
            queue.dequeue();

            queue.display();

            queue.enqueue(60);
            queue.enqueue(70);

            queue.display();
        }
    }
