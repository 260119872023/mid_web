package DAO;

import Controller.HibernateUtil;
import Model.StudentReg;
import org.hibernate.Session;

public class studentRegDAO {
    public StudentReg save(StudentReg obj)
    {
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(obj);
            ss.beginTransaction().commit();
            ss.close();
            return obj;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
