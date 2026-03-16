import java.util.Stack;

class MyQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    // Push element x to the back of queue
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from the front of queue and returns it
    public int pop() {
        peek();
        return out.pop();
    }

    // Get the front element
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
