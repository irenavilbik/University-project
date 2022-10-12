public class Exam {
    private final int ExamID;
    private final int ExamDATE;
    private final String ExamName;

    public Exam(int examID, int examDATE, String examName) {
        ExamID = examID;
        ExamDATE = examDATE;
        ExamName = examName;
    }

    public String getExamName() {
        return ExamName;
    }

    public int getExamID() {
        return ExamID;
    }

    public int getExamDATE() {
        return ExamDATE;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "ExamID=" + ExamID +
                ", ExamDATE=" + ExamDATE +
                ", ExamName='" + ExamName + '\'' +
                '}';
    }
}
