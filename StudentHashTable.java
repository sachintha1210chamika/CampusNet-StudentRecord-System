public class StudentHashTable {
    private class HashNode {
        String studentId;
        Student student;
        HashNode next;

        HashNode(String studentId, Student student) {
            this.studentId = studentId;
            this.student = student;
            this.next = null;
        }
    }

    private HashNode[] buckets;
    private int numBuckets;

    public StudentHashTable(int capacity) {
        this.numBuckets = capacity;
        this.buckets = new HashNode[numBuckets];
    }

    private int getBucketIndex(String studentId) {
        return Math.abs(studentId.hashCode()) % numBuckets;
    }

    public void insert(Student student) {
        int bucketIndex = getBucketIndex(student.getStudentId());
        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.studentId.equals(student.getStudentId())) {
                head.student = student;
                return;
            }
            head = head.next;
        }

        HashNode newNode = new HashNode(student.getStudentId(), student);
        newNode.next = buckets[bucketIndex];
        buckets[bucketIndex] = newNode;
    }

    public Student search(String studentId) {
        int bucketIndex = getBucketIndex(studentId);
        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.studentId.equals(studentId)) {
                return head.student;
            }
            head = head.next;
        }
        return null;
    }
}