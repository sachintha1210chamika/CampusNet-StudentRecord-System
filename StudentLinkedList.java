public class StudentLinkedList {
    private StudentNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    // Add Student Record
    public void addStudent(Student student) {
        StudentNode newNode = new StudentNode(student);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Student record added successfully!");
    }

    // Display All Student Records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- All Student Records ---");
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.student);
            temp = temp.next;
        }
    }

    // Search Student by ID
    public Student searchStudent(String studentId) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.student.getStudentId().equalsIgnoreCase(studentId)) {
                return temp.student;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update Student Record
    public boolean updateStudent(String studentId, String newName, String newProgramme, double newMarks) {
        Student student = searchStudent(studentId);
        if (student != null) {
            student.setName(newName);
            student.setProgramme(newProgramme);
            student.setMarks(newMarks);
            return true;
        }
        return false;
    }

    // Delete Student Record
    public Student deleteStudent(String studentId) {
        if (head == null) return null;

        if (head.student.getStudentId().equalsIgnoreCase(studentId)) {
            Student deletedStudent = head.student;
            head = head.next;
            return deletedStudent;
        }

        StudentNode current = head;
        StudentNode previous = null;

        while (current != null && !current.student.getStudentId().equalsIgnoreCase(studentId)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            return current.student;
        }

        return null;
    }

    public StudentNode getHead() {
        return head;
    }
}