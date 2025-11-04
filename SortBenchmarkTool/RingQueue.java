/**
 * RingQueue (Circular Queue)
 * --------------------------
 * A simple implementation of a circular queue (ring buffer)
 * using an array. Both enqueue and dequeue operations run in O(1).
 *
 * Key Concepts:
 *  - Using the modulo operator for index wrapping
 *  - Managing queue state with front, rear, and count
 *  - Preventing overflow via capacity checks
 *
 * Example:
 *  RingQueue q = new RingQueue(3);
 *  q.enqueue(10);
 *  q.enqueue(20);
 *  System.out.println(q.dequeue()); // 10
 *
 * Author: Vladimir Kirizleev (@vkir090)
 * License: MIT (free for educational and commercial use)
 */

public class RingQueue {
    private final int[] data;
    private int front;
    private int rear;
    private int count;
    private final int capacity;

    public RingQueue(int capacity) {
        this.data = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.capacity = capacity;
    }

    /** Adds an element to the queue (O(1)). */
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        data[rear] = value;
        rear = (rear + 1) % capacity;
        count++;
    }

    /** Removes and returns the front element (O(1)). */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = data[front];
        data[front] = 0;
        front = (front + 1) % capacity;
        count--;
        return element;
    }

    /** Returns the front element without removing it. */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    /** Checks if the queue is empty. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks if the queue is full. */
    public boolean isFull() {
        return count == capacity;
    }

    /** Returns the current number of elements. */
    public int size() {
        return count;
    }
}
