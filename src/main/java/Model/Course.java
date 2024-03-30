package Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    private String course_code;
    private String Name;
    private Integer Credit;

    @OneToOne(mappedBy = "course")
    private CourseDefinition courseDefinition;
    @OneToMany(mappedBy = "courseSet")
    private List<StudentCourse> studentCourseList = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "sem_Id")
    private Semester Semester_Course;
    @ManyToOne
    @JoinColumn(name = "academic_id")
    private AcademicUnit academicUnit;
    @OneToMany(mappedBy = "courses")
    private List<Teacher> teachers = new ArrayList<>();

    public Course() {
    }
    public Course(Integer course_id) {
        this.course_id = course_id;
    }

    public Course(Integer course_id, String course_code, String name, Integer credit, CourseDefinition courseDefinition, List<StudentCourse> studentCourseList, Semester semester_Course, AcademicUnit academicUnit, List<Teacher> teachers) {
        this.course_id = course_id;
        this.course_code = course_code;
        Name = name;
        Credit = credit;
        this.courseDefinition = courseDefinition;
        this.studentCourseList = studentCourseList;
        Semester_Course = semester_Course;
        this.academicUnit = academicUnit;
        this.teachers = teachers;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public CourseDefinition getCourseDefinition() {
        return courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    public Integer getCredit() {
        return Credit;
    }

    public void setCredit(Integer credit) {
        Credit = credit;
    }

    public List<StudentCourse> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<StudentCourse> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    public Semester getSemester_Course() {
        return Semester_Course;
    }

    public void setSemester_Course(Semester semester_Course) {
        Semester_Course = semester_Course;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    
    @Override
    public String toString(){
        return Name;
    }
}
