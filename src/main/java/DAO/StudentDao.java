package DAO;

import Controller.HibernateUtil;
import Model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {
    public Student register(Student stdobj)
    {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(stdobj);
            ss.beginTransaction().commit();
            ss.close();
            return stdobj;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public Student getStudentByRegNo(String regNo) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();
            Student student = session.createQuery("FROM Student WHERE regNo = :regNo", Student.class)
                    .setParameter("regNo", regNo)
                    .uniqueResult();
            tr.commit();
            session.close();

            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student Search(Student stdobj)
    {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Student stud = ss.get(Student.class, stdobj.getRegNo());
            ss.close();
            return stud;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public List<Student> all_students()
    {
        try
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Student> studentList=session.createQuery("select stud from Student stud").list();
            session.close();
            return studentList;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
