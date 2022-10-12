import java.sql.Connection;
import java.sql.SQLException;

public interface ExamInterface {
    void viewExamList(Connection connection) throws SQLException, ClassNotFoundException;

    void createExam(Connection connection, int ExamID, int ExamDATE, String ExamName) throws SQLException, ClassNotFoundException ;

    void viewExamResult(Connection connection, int inputID) throws SQLException, ClassNotFoundException;

    void findExamByCourse(Connection connection, String inputID) throws SQLException, ClassNotFoundException ;
}
