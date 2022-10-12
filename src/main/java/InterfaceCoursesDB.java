

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceCoursesDB {
    ArrayList<Course> getCourses() throws SQLException, ClassNotFoundException;

    Course getCourseByTitle(String title) throws SQLException, ClassNotFoundException;

    void addCourse(String title, int duration) throws SQLException, ClassNotFoundException;
}