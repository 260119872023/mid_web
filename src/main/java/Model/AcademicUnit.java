package Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Code;
    private String Name;
    private CourseEnum program_type;
    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = true)
    private AcademicUnit academicUnit;

    @OneToMany(mappedBy = "academicUnit")
    private List<Course> courses = new ArrayList<>();
    @OneToMany(mappedBy = "student_registration")
    private List<StudentReg> studentRegList = new ArrayList<>();

    public AcademicUnit() {
    }

    public AcademicUnit(Integer id) {
        this.id = id;
    }

    public AcademicUnit(Integer id, String code, String name, CourseEnum program_type, AcademicUnit academicUnit, List<Course> courses, List<StudentReg> studentRegList) {
        this.id = id;
        Code = code;
        Name = name;
        this.program_type = program_type;
        this.academicUnit = academicUnit;
        this.courses = courses;
        this.studentRegList = studentRegList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public CourseEnum getProgram_type() {
        return program_type;
    }

    public void setProgram_type(CourseEnum program_type) {
        this.program_type = program_type;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<StudentReg> getStudentRegList() {
        return studentRegList;
    }

    public void setStudentRegList(List<StudentReg> studentRegList) {
        this.studentRegList = studentRegList;
    }
}
