package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Semester implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sem_Id;
    private String Name;
    private Date startDate;
    private Date endDate;
    @OneToMany(mappedBy = "Semester")
    private List<StudentReg> studentRegList= new ArrayList<>();
    @OneToMany(mappedBy = "Semester_Course")
    private List<Course> courseList = new ArrayList<>();

    @OneToMany(mappedBy = "semester")
    private List<StudentCourse> studentCourseList = new ArrayList<>();

    public Semester() {
    }
    public Semester(Integer sem_Id) {
        this.sem_Id = sem_Id;
    }

    public Semester(Integer sem_Id, String name, Date startDate, Date endDate, List<StudentReg> studentRegList, List<Course> courseList, List<StudentCourse> studentCourseList) {
        this.sem_Id = sem_Id;
        Name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentRegList = studentRegList;
        this.courseList = courseList;
        this.studentCourseList = studentCourseList;
    }



    public List<StudentCourse> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<StudentCourse> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    public Integer getSem_Id() {
        return sem_Id;
    }

    public void setSem_Id(Integer sem_Id) {
        this.sem_Id = sem_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<StudentReg> getStudentRegList() {
        return studentRegList;
    }

    public void setStudentRegList(List<StudentReg> studentRegList) {
        this.studentRegList = studentRegList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString(){
        return Name;
    }
}
