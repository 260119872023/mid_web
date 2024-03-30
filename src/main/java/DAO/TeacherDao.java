package DAO;

import Controller.HibernateUtil;
import Model.Course;
import Model.Qualification;
import Model.Teacher;
import org.hibernate.Session;

import java.util.List;

public class TeacherDao {
    public Teacher save_teacher(Teacher objec)
    {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(objec);
            ss.beginTransaction().commit();
            ss.close();
            return objec;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Teacher> all_teachers()
    {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Teacher> teachers = ss.createQuery("select tech from Teacher tech").list();
            ss.close();
            return teachers;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public Teacher delete_lecture(Teacher lect)
    {
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(lect);
            ss.beginTransaction().commit();
            ss.close();
            return lect;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public Teacher update_lecture(Teacher lect)
    {
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(lect);
            ss.beginTransaction().commit();
            ss.close();
            return lect;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public Teacher search_lecture(Teacher lecture)
    {
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            Teacher teachers = session.get(Teacher.class, lecture.getTeacher_id());
            session.close();
            return teachers;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Teacher> getTeacherscourse(Teacher Teacobj) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Teacher> TeacherData = session.createQuery("Select ad  FROM Teacher ad where  Email=:emid ")
                    .setParameter("emid", Teacobj.getEmail())
                    .list();
            session.beginTransaction().commit();
            session.close();

            return TeacherData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
