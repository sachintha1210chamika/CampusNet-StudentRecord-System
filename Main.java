import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data Structures Initialization
        ActionStack actionStack = new ActionStack();
        RequestQueue requestQueue = new RequestQueue();
        StudentHashTable hashTable = new StudentHashTable(10);
        StudentBST bst = new StudentBST();

        // Campus Graph Setup
        String[] locations = {"Library", "Main Hall", "Lab 01", "Canteen"};
        CampusGraph graph = new CampusGraph(locations);
        graph.addEdge(0, 1, 100);
        graph.addEdge(1, 2, 150);
        graph.addEdge(0, 2, 300);
        graph.addEdge(2, 3, 80);

        while (true) {
            System.out.println("\n==================================================");
            System.out.println("   CAMPUSNET STUDENT RECORD & ROUTE SYSTEM       ");
            System.out.println("==================================================");
            System.out.println("1. Add Student Record");
            System.out.println("2. Display All Students (BST)");
            System.out.println("3. Search Student (Hashing)");
            System.out.println("4. Add Service Request (Queue)");
            System.out.println("5. Process Next Request (Queue)");
            System.out.println("6. Display Recent Actions (Stack)");
            System.out.println("7. Display Campus Graph Connections");
            System.out.println("8. Traverse Campus Network (BFS/DFS / Shortest Path)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Programme: ");
                    String prog = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    Student student = new Student(id, name, prog, marks);
                    hashTable.insert(student);
                    bst.insert(student);
                    actionStack.push(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Students List (BST In-Order) ---");
                    bst.displayInOrder();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    String searchId = scanner.nextLine();
                    Student found = hashTable.search(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Request Details: ");
                    String req = scanner.nextLine();
                    requestQueue.enqueue(req);
                    break;

                case 5:
                    requestQueue.displayQueue();
                    break;

                case 6:
                    System.out.println("\n--- Action History (Stack) ---");
                    actionStack.displayStack();
                    break;

                case 7:
                    System.out.println("\n--- Campus Locations & Routes ---");
                    graph.dijkstra(0);
                    break;

                case 8:
                    System.out.println("\n--- Campus Graph Traversal ---");
                    graph.dijkstra(0);
                    break;

                case 9:
                    System.out.println("Exiting System... Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}