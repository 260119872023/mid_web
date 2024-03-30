package DAO;

import Controller.HibernateUtil;
import Model.Student;
import Model.user;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class userdao {
    public user register(user userobj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.save(userobj);
            session.beginTransaction().commit();
            session.close();
            return userobj;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public user loginpage(user userobj)
    {
        try
        {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();
            String qry="FROM user WHERE email = :email AND password = :password";
            Query query = ss.createQuery(qry);
            query.setParameter("email",userobj.getEmail());
            query.setParameter("password",userobj.getPassword());
            user users = (user) query.uniqueResult();
            ss.getTransaction().commit();
            ss.close();
            return users;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<user> login_user(user userobj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<user> userList = ss.createQuery("select use from user use where email =:Email_lo AND password =:pass_lo AND role =: role_lo")
                    .setParameter("role_lo",userobj.getRole())
                    .setParameter("pass_lo",userobj.getPassword())
                    .setParameter("Email_lo",userobj.getEmail())
                    .list();
            ss.beginTransaction().commit();
            ss.close();
            return userList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
