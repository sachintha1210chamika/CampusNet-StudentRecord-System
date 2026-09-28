public class RequestQueue {
    private class Node {
        String requestDescription;
        Node next;

        Node(String requestDescription) {
            this.requestDescription = requestDescription;
            this.next = null;
        }
    }

    private Node front, rear;

    public RequestQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(String request) {
        Node newNode = new Node(request);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Request added to queue successfully.");
    }

    public String dequeue() {
        if (front == null) {
            System.out.println("No pending requests in queue.");
            return null;
        }
        String processedRequest = front.requestDescription;
        front = front.next;
        if (front == null) rear = null;
        return processedRequest;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("No pending requests in queue.");
            return;
        }
        System.out.println("\n--- Pending Service Requests (Queue) ---");
        Node temp = front;
        while (temp != null) {
            System.out.println("- " + temp.requestDescription);
            temp = temp.next;
        }
    }
}
