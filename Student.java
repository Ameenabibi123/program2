import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student {
    private String name;
    private LocalDate dateOfBirth;

    public Student(String name, String dobString) {
        this.name = name;
        this.dateOfBirth = parseDateOfBirth(dobString);
    }

    // Parses DOB in either "dd-MM-yyyy" or "yyyy-MM-dd" format
    private LocalDate parseDateOfBirth(String dobString) {
        DateTimeFormatter[] formats = {
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
        };

        for (DateTimeFormatter format : formats) {
            try {
                return LocalDate.parse(dobString, format);
            } catch (DateTimeParseException e) {
                // Try next format
            }
        }

        throw new IllegalArgumentException("Date of Birth format must be either DD-MM-YYYY or YYYY-MM-DD");
    }

    public void displayStudentInfo() {
        LocalDate today = LocalDate.now();
        int age = Period.between(this.dateOfBirth, today).getYears();
        System.out.println("Student Name: " + this.name);
        System.out.println("Student Age: " + age + " years");
    }

    // Main method for testing
    public static void main(String[] args) {
        Student student1 = new Student("Ameena", "2004-11-11");
        student1.displayStudentInfo();

        Student student2 = new Student("Shonu", "21-03-2003");
        student2.displayStudentInfo();
    }
}
