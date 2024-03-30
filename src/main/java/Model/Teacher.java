package Model;

import jakarta.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;
    private String Names;
    private String Email;
    private Qualification qualifications;
    @ManyToOne
    @JoinColumn(name = "Course_id")
    private Course courses;

    public Teacher() {
    }
    public Teacher(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Teacher(Integer teacher_id, String names, String email, Qualification qualifications, Course courses) {
        this.teacher_id = teacher_id;
        Names = names;
        Email = email;
        this.qualifications = qualifications;
        this.courses = courses;
    }


    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }


    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public Qualification getQualifications() {
        return qualifications;
    }

    public void setQualifications(Qualification qualifications) {
        this.qualifications = qualifications;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
