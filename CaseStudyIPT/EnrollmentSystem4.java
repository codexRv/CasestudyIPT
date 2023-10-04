import java.util.*;

class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private int courseId;
    private String courseName;
    private List<Student> enrolledStudents;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }
}

class EnrollmentSystem {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public void addStudent(int studentId, String name) {
        if (findStudent(studentId).isPresent()) {
            System.out.println("Student with ID " + studentId + " already exists.");
        } else {
            students.add(new Student(studentId, name));
        }
    }

    public void addCourse(int courseId, String courseName) {
        if (findCourse(courseId).isPresent()) {
            System.out.println("Course with ID " + courseId + " already exists.");
        } else {
            courses.add(new Course(courseId, courseName));
        }
    }

    public void enrollStudent(int studentId, int courseId) {
        Student student = findStudent(studentId).orElse(null);
        Course course = findCourse(courseId).orElse(null);

        if (student == null || course == null) {
            System.out.println("Student or course not found.");
        } else if (course.getEnrolledStudents().contains(student)) {
            System.out.println(student.getName() + " is already enrolled in " + course.getCourseName() + ".");
        } else {
            course.enrollStudent(student);
            System.out.println(student.getName() + " has been enrolled in " + course.getCourseName() + ".");
        }
    }

    private Optional<Student> findStudent(int studentId) {
        return students.stream().filter(student -> student.getStudentId() == studentId).findFirst();
    }

    private Optional<Course> findCourse(int courseId) {
        return courses.stream().filter(course -> course.getCourseId() == courseId).findFirst();
    }
}

public class Main {
    public static void main(String[] args) {
        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();

        enrollmentSystem.addStudent(1, "John Doe");
        enrollmentSystem.addStudent(2, "Jane Smith");
        enrollmentSystem.addCourse(101, "Math 101");
        enrollmentSystem.addCourse(102, "English 101");

        enrollmentSystem.enrollStudent(1, 101); // Enroll John Doe in Math 101
        enrollmentSystem.enrollStudent(1, 101); // Try to enroll John Doe again (should show a message)
        enrollmentSystem.enrollStudent(2, 102); // Enroll Jane Smith in English 101
        enrollmentSystem.enrollStudent(3, 101); // Try to enroll a non-existent student (should show a message)
        enrollmentSystem.enrollStudent(2, 103); // Try to enroll in a non-existent course (should show a message)
    }
}
