package DAO;

import Controller.HibernateUtil;
import Model.StudentCourse;
import org.hibernate.Session;

public class StudentCOurseDao {
    public StudentCourse registerStudent(StudentCourse stdobj)
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
}
