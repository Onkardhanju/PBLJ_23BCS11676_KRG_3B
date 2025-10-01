import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Custom Exception
class EmptyStudentListException extends Exception {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class StudentList {
    private ArrayList<String> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    // Add student
    public void addStudent(String name) {
        students.add(name);
    }

    // Remove student
    public void removeStudent(String name) {
        students.remove(name);
    }

    // Display students in alphabetical order
    public void displayStudents() throws EmptyStudentListException {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("Student list is empty!");
        }
        Collections.sort(students);
        System.out.println("Sorted names: " + students);
    }
}

public class que2 {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student List Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = sc.nextLine();
                    list.addStudent(nameToAdd);
                    break;

                case 2:
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = sc.nextLine();
                    list.removeStudent(nameToRemove);
                    break;

                case 3:
                    try {
                        list.displayStudents();
                    } catch (EmptyStudentListException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
