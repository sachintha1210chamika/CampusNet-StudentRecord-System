public class ActionStack {
    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node top;

    public ActionStack() {
        this.top = null;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
        System.out.println("Action recorded in stack.");
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("No actions to undo.");
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        return poppedStudent;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Recent actions stack is empty.");
            return;
        }
        System.out.println("\n--- Recently Deleted Students (Stack) ---");
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.student);
            temp = temp.next;
        }
    }
}
