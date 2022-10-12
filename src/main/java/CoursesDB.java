import java.sql.*;
import java.util.ArrayList;

public class CoursesDB implements InterfaceCoursesDB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    /*ArrayList<Course> c = getCourses();
    for(Course course: c){
        System.out.println(course);
    }*/
        //System.out.println(getCourseByTitle("Web technology"));

    }

    @Override
    public ArrayList<Course> getCourses() throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        String sql = "select * from courses";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        ArrayList<Course> courses = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String courseTitle = rs.getNString("Title");
            int courseDur = rs.getInt("Duration");
            Course course = new Course(id, courseTitle, courseDur);
            courses.add(course);
        }
        con.close();
        return courses;
    }

    @Override
    public Course getCourseByTitle(String title) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        String sql = "select * from courses where title = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, title);
        ResultSet rs = stmt.executeQuery();
        Course course = null;
        if (rs.next()) {
            int courseID = rs.getInt("ID");
            String courseTitle = rs.getString("Title");
            int courseDur = rs.getInt("Duration");
            course = new Course(courseID, courseTitle, courseDur);
        }
        con.close();
        return course;
    }

    @Override
    public void addCourse(String title, int duration) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        String sql = "INSERT INTO courses (Title, Duration) values (?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, title);
        stmt.setInt(2, duration);
        stmt.executeUpdate();
        con.close();
    }


    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
        return con;
    }


}