public class StudentBST {
    private class BSTNode {
        Student student;
        BSTNode left, right;

        BSTNode(Student student) {
            this.student = student;
            this.left = this.right = null;
        }
    }

    private BSTNode root;

    public StudentBST() {
        this.root = null;
    }

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private BSTNode insertRec(BSTNode root, Student student) {
        if (root == null) {
            return new BSTNode(student);
        }
        if (student.getMarks() < root.student.getMarks()) {
            root.left = insertRec(root.left, student);
        } else {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public void displayInOrder() {
        System.out.println("\n--- Students Sorted by Marks (BST In-Order) ---");
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.student);
            inOrderRec(root.right);
        }
    }
}