package console_view;

import model.Student;

public class StudentView {
    public static void display(Student student) {
        System.out.printf("%s %s (%s)%n", student.getFirstName(), student.getLastName(), student.getEmailAddress());
    }

    /**
     * Prompt user for inputs and create student
     * <p>
     * This method prompts the user to enter a student's first name, middle name,
     * last name, and PSU login. Using the user inputs, this method creates
     * a new student and returns the student to the caller.
     *
     * @return the student created by the user
     * 
     */
    public static Student createStudent() {
        // TODO 06 - [console_view.StudentView.createStudent] Prompt for student info, create and return the student
        String firstName = ViewUtil.readNonBlankStringFromKeyboard("First name");
        String middleName = ViewUtil.readStringFromKeyboard("Middle name");
        String lastName = ViewUtil.readNonBlankStringFromKeyboard("Last name");
        String login = ViewUtil.readNonBlankStringFromKeyboard("PSU login");

        return new Student(lastName, firstName, middleName, login);
    }

    /**
     * Display student detail
     * <p>
     * This method allows the user to provide a student and then displays
     * the student's last name, first name, middle name, PSU login, and PSU email.
     *
     * @param student the student provided by the user
     * 
     */
    public static void displayDetail(Student student) {
        // TODO 07 - [console_view.StudentView.displayDetail] Display student detail
        System.out.println("  Last name : " + student.getLastName());
        System.out.println(" First name : " + student.getFirstName());
        System.out.println("Middle name : " + student.getMiddleName());
        System.out.println("  PSU login : " + student.getLogin());
        System.out.println("  PSU email : " + student.getEmailAddress());
    }
}
