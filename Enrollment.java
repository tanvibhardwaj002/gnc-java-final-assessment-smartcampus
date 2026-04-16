import java.util.ArrayList;
import java.util.HashMap;

public class Enrollment {
    private HashMap<Student, ArrayList<Course>> enrollments;

    // Constructor
    public Enrollment() {
        this.enrollments = new HashMap<>();
    }

    // Enroll student in a course
    public void enroll(Student student, Course course) {
        this.enrollments.putIfAbsent(student, new ArrayList<>());
        this.enrollments.get(student).add(course);

        System.out.println("Enrolled " + student.getName() + 
                           " in " + course.getCourseName());
    }

    // View all enrollments
    public void viewEnrollments() {
        for (Student s : this.enrollments.keySet()) {
            System.out.println(s + " -> " + this.enrollments.get(s));
        }
    }
}
