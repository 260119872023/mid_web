package Controller;

import Model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
public class HibernateUtil {
    private static SessionFactory sessionFactory;

        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();

                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/auca_registartion");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                properties.put(Environment.SHOW_SQL, true);

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(AcademicUnit.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Semester.class);
                configuration.addAnnotatedClass(StudentCourse.class);
                configuration.addAnnotatedClass(CourseDefinition.class);
                configuration.addAnnotatedClass(StudentReg.class);
                configuration.addAnnotatedClass(user.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            return sessionFactory;
        }
}
