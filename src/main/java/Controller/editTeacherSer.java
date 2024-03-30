package Controller;

import DAO.TeacherDao;
import Model.Course;
import Model.Qualification;
import Model.Teacher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/editTeacherSer")
public class editTeacherSer extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRe(request,response);
    }
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRe(request,response);
    }
    private void processRe(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getParameter("put_method");
        if("PUT".equals(method))
        {
            int Id = Integer.parseInt(request.getParameter("lectid"));
            String Names = request.getParameter("teacher");
            String qual = request.getParameter("qual_edit");
            int course_Id = Integer.parseInt(request.getParameter("course_ed"));

            Teacher teacher = new Teacher();
            teacher.setTeacher_id(Id);
            teacher.setNames(Names);
            teacher.setQualifications(Qualification.valueOf(qual));
            Course courses = new Course();
            courses.setCourse_id(course_Id);
            teacher.setCourses(courses);

            TeacherDao dao = new TeacherDao();
            dao.update_lecture(teacher);
            if(teacher!=null)
            {
                response.sendRedirect("teacherFormall.jsp");
            }
            else {
                response.sendRedirect("AdminPortal.jsp");
            }
        }
        else
        {

        }
    }
}
