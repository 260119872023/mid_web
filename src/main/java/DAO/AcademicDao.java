package DAO;

import Controller.HibernateUtil;
import Model.AcademicUnit;
import Model.CourseEnum;
import org.hibernate.Session;

import java.util.List;

public class AcademicDao {
    public AcademicUnit register(AcademicUnit object){
        try
        {
            Session ses = HibernateUtil.getSessionFactory().openSession();
            ses.save(object);
            ses.beginTransaction().commit();
            ses.close();
            return object;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<AcademicUnit> getfacultyandprograms(){
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();

            List<AcademicUnit> accademic_data=session.createQuery("select ad from AcademicUnit ad where program_type= :data OR program_type= :data1")
                    .setParameter("data", CourseEnum.FACULTY)
                    .setParameter("data1", CourseEnum.PROGRAM)
                    .list();
            session.beginTransaction().commit();
            session.close();
            return accademic_data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<AcademicUnit> getdepartment(){
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();

            List<AcademicUnit> accademic_data=session.createQuery("select ad from AcademicUnit ad where program_type= :data")
                    .setParameter("data", CourseEnum.DEPARTMENT)
                    .list();
            session.beginTransaction().commit();
            session.close();
            return accademic_data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
