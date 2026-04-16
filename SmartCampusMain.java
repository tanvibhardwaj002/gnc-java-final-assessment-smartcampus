import java.util.*;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class SmartCampusMain {

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static Enrollment enrollment = new Enrollment();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Smart Campus System");

        while (true) {
            System.out.println("\n--- SmartCampus Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. View Students");
            System.out.println("5. View Enrollments");
            System.out.println("6. Process Enrollment (Thread)");
            System.out.println("7. Exit");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        addCourse();
                        break;
                    case 3:
                        enrollStudent();
                        break;
                    case 4:
                        viewStudents();
                        break;
                    case 5:
                        enrollment.viewEnrollments();
                        break;
                    case 6:
                        processEnrollment();
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        throw new InvalidInputException("Invalid menu choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    // Add Student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        students.add(new Student(id, name, email));
    }

    // Add Course
    private static void addCourse() {
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Fee: ");
        double fee = sc.nextDouble();

        if (fee < 0) {
            System.out.println("Invalid fee!");
            return;
        }

        courses.add(new Course(id, name, fee));
    }

    // Enroll Student
    private static void enrollStudent() {

        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();

        System.out.print("Enter Course ID: ");
        int cid = sc.nextInt();

        Student s = students.stream()
                .filter(st -> st.getStudentId() == sid)
                .findFirst()
                .orElse(null);

        Course c = courses.stream()
                .filter(co -> co.getCourseId() == cid)
                .findFirst()
                .orElse(null);

        if (s == null || c == null) {
            System.out.println("Invalid Student or Course ID!");
            return;
        }

        enrollment.enroll(s, c);
    }

    // View Students
    private static void viewStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Multithreading
    private static void processEnrollment() {

        Thread t = new Thread(() -> {
            System.out.println("Processing enrollments asynchronously...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }

            enrollment.viewEnrollments();
        });

        t.start();
    }
}
