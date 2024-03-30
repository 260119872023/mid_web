package Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {
    @Id
    private String regNo;
    private String name;
    private Date dateOfBirth;
    @OneToMany(mappedBy = "students")
    private List<StudentReg> studentRegList = new ArrayList<>();
    @OneToMany(mappedBy = "student_reg")
    private List<StudentCourse> studentcourseList = new ArrayList<>();

    public Student() {
    }

    public Student(String regNo) {
        this.regNo = regNo;
    }

    public Student(String regNo, String name, Date dateOfBirth, List<StudentReg> studentRegList) {
        this.regNo = regNo;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.studentRegList = studentRegList;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<StudentReg> getStudentRegList() {
        return studentRegList;
    }

    public void setStudentRegList(List<StudentReg> studentRegList) {
        this.studentRegList = studentRegList;
    }
}