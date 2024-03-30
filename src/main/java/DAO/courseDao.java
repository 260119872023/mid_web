package DAO;

import Controller.HibernateUtil;
import Model.Course;
import org.hibernate.Session;

import java.util.List;

public class courseDao {
    public Course registerCourse(Course obj)
    {
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(obj);
            ss.beginTransaction().commit();
            ss.close();
            return obj;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Course> allcourses()
    {
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Course> courseList = ss.createQuery("select cour from Course cour").list();
            ss.close();
            return courseList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Course> getdepartmentandSemester(Course courseobj) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Course> courseData = session.createQuery("Select ad  FROM Course ad where academicUnit =:accid AND Semester_Course =:semid")
                    .setParameter("semid", courseobj.getSemester_Course())
                    .setParameter("accid", courseobj.getAcademicUnit())
                    .list();
            session.beginTransaction().commit();
            session.close();

            return courseData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
