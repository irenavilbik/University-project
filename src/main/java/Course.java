public class Course {
    private final int courseID;
    private final String title;
    private final int duration;

    public Course(int courseID, String title, int duration) {
        this.courseID = courseID;
        this.title = title;
        this.duration = duration;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("CourseID %d  Course title: \"%s\" --- Duration: %d hours", courseID, title, duration);
    }
}