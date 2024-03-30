package Controller;

import DAO.TeacherDao;
import Model.Course;
import Model.Qualification;
import Model.Teacher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherServelet")
public class TeacherServelet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Names = request.getParameter("name");
        String course_id = request.getParameter("course");
        String Email = request.getParameter("email");
        String qualification = request.getParameter("qualification");

        Qualification qual = Qualification.valueOf(qualification);
        Course cour= new Course();
        cour.setCourse_id(Integer.valueOf(course_id));
        Teacher teach = new Teacher();
        teach.setCourses(cour);
        teach.setNames(Names);
        teach.setEmail(Email);
        teach.setQualifications(qual);

        TeacherDao dao = new TeacherDao();
        String result = String.valueOf(dao.save_teacher(teach));
        if (result!=null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPortal.jsp.html");
            dispatcher.forward(request, response);
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDao teacherDao = new TeacherDao();
        List<Teacher> all_teachers = teacherDao.all_teachers();
        request.setAttribute("all_teachers", all_teachers);
        request.getRequestDispatcher("/teacherFormall.jsp").forward(request, response);
    }

}
