import java.lang.String;

public class Students implements IStudents {

    private int courseId;
    private String Name;
    private String surname;
    private int dateOfBirth;


    public Students() {

    }


    public String setName(String Name) {
        this.Name = Name;
        return Name;
    }
    public String setSurname(String surname){
        this.surname = surname;
        return surname;
    }

    public int setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return dateOfBirth;
    }


    public int setCourseId(int courseId) {
        this.courseId = courseId;
        return courseId;
    }

    @Override
    public String toString() {
        return String.format("StudentsId %d  Students full_name: \"%s\" --- date_of_birth: %d ", fullName, dateOfBirth);
    }

    @Override
    public void addStudent() {

    }

    @Override
    public void viewAllStudents() {
    }

    @Override
    public void viewStudentInfo() {
    }
}