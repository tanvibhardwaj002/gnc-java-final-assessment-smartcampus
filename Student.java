public class Student {
    private int studentId;
    private String name;
    private String email;

    // Constructor using this
    public Student(int studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    // Getters
    public int getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString
    public String toString() {
        return "Student [ID=" + this.studentId + ", Name=" + this.name + ", Email=" + this.email + "]";
    }
}
