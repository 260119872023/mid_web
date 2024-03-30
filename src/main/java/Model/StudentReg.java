package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
public class StudentReg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reg_id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student students;
    @ManyToOne
    @JoinColumn(name ="sem_Id")
    private Semester Semester;
    @ManyToOne
    @JoinColumn(name = "academic_id")
    private AcademicUnit student_registration;
    private Date registration_date;

    public StudentReg() {
    }
    public StudentReg(Integer reg_id) {
        this.reg_id = reg_id;
    }

    public StudentReg(Integer reg_id, Student student_Id, Model.Semester semester, AcademicUnit student_registration, Date registration_date) {
        this.reg_id = reg_id;
        this.students = student_Id;
        Semester = semester;
        this.student_registration = student_registration;
        this.registration_date = registration_date;
    }

    public Integer getReg_id() {
        return reg_id;
    }

    public void setReg_id(Integer reg_id) {
        this.reg_id = reg_id;
    }

    public Student getStudent_Id() {
        return students;
    }

    public void setStudent_Id(Student student_Id) {
        this.students = student_Id;
    }

    public Model.Semester getSemester() {
        return Semester;
    }

    public void setSemester(Model.Semester semester) {
        Semester = semester;
    }

    public AcademicUnit getStudent_registration() {
        return student_registration;
    }

    public void setStudent_registration(AcademicUnit student_registration) {
        this.student_registration = student_registration;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
