package DAO;

import Controller.HibernateUtil;
import Model.Semester;
import org.hibernate.Session;

import java.util.List;

public class semesterDao {
    public Semester register(Semester semester){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(semester);
            ss.beginTransaction().commit();
            ss.close();
            return semester;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Semester> allsemesters()
    {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Semester> semesterList = ss.createQuery("select sem from Semester sem ").list();
            ss.close();
            return semesterList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
