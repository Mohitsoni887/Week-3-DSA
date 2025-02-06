/*
 * Implement a Queue Using Stacks
Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.
 */
import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (push to stack1)
    public void enqueue(int data) {
        stack1.push(data);
    }

    // Dequeue operation (pop from stack2)
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation (front element)
    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // Output: 10
        System.out.println(queue.peek());    // Output: 20
        System.out.println(queue.dequeue()); // Output: 20
        System.out.println(queue.isEmpty()); // Output: false
    }
}
