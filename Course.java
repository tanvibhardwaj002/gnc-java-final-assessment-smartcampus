public class Course {
    private int courseId;
    private String courseName;
    private double fee;

    // Constructor using this
    public Course(int courseId, String courseName, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
    }

    // Getter methods using this
    public int getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public double getFee() {
        return this.fee;
    }

    // Setter methods using this
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    // toString
    public String toString() {
        return "Course [ID=" + this.courseId + ", Name=" + this.courseName + ", Fee=" + this.fee + "]";
    }
}