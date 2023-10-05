public void displayStatistics() {
    System.out.println("Total number of students: " + students.size());
    System.out.println("Total number of courses: " + courses.size());
}

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

    enrollmentSystem.displayStatistics(); // Display the statistics
}
