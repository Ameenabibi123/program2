import java.util.*;

public class StudentCourses {
    private Map<Integer, List<Course>> semesterCourses;

    public StudentCourses() {
        semesterCourses = new HashMap<>();
    }

    public void addCourse(int semester, String courseName, int marks) {
        Course course = new Course(courseName, marks);
        semesterCourses.computeIfAbsent(semester, k -> new ArrayList<>()).add(course);
    }

    public void displayCourses() {
        for (int semester : semesterCourses.keySet()) {
            System.out.println("Semester " + semester + ":");
            for (Course course : semesterCourses.get(semester)) {
                System.out.println("  " + course.getName() + ": " + course.getMarks() + " marks");
            }
        }
    }

    // Inner class to represent a course
    private static class Course {
        private String name;
        private int marks;

        public Course(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }
    }
}
