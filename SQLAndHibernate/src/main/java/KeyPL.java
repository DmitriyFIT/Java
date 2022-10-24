import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyPL implements Serializable {

    public KeyPL() {
    }

    public KeyPL(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyPL keyPL)) return false;
        return Objects.equals(studentName, keyPL.studentName) && Objects.equals(courseName, keyPL.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName);
    }
}
