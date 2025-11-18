package DSAAssgmnt;

public class QueueUsingLinkedList {
    // Node class
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // Queue class
        static class Queue {
            private Node front, rear;

            // Enqueue
            public void enqueue(int value) {
                Node newNode = new Node(value);

                if (rear == null) { // empty queue
                    front = rear = newNode;
                    System.out.println(value + " added to queue");
                    return;
                }

                rear.next = newNode;
                rear = newNode;
                System.out.println(value + " added to queue");
            }

            // Dequeue
            public int dequeue() {
                if (front == null) {
                    throw new RuntimeException("Queue Underflow");
                }

                int value = front.data;
                front = front.next;

                if (front == null) { // queue becomes empty
                    rear = null;
                }

                return value;
            }

            // Peek
            public int peek() {
                if (front == null) {
                    throw new RuntimeException("Queue is Empty");
                }
                return front.data;
            }

            // Empty check
            public boolean isEmpty() {
                return front == null;
            }
        }

        // Main Method
        public static void main(String[] args) {
            Queue queue = new Queue();

            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            System.out.println("Front = " + queue.peek());
            System.out.println("Dequeued = " + queue.dequeue());
            System.out.println("Front = " + queue.peek());
        }
    }

