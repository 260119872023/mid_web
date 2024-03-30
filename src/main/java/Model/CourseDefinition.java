package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class CourseDefinition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer def_id;
    private String Description;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public CourseDefinition() {
    }

    public CourseDefinition(Integer def_id) {
        this.def_id = def_id;
    }

    public CourseDefinition(Integer def_id, String description, Course course) {
        this.def_id = def_id;
        Description = description;
        this.course = course;
    }

    public Integer getDef_id() {
        return def_id;
    }

    public void setDef_id(Integer def_id) {
        this.def_id = def_id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
