package Controller;

import DAO.courseDao;
import Model.AcademicUnit;
import Model.Course;
import Model.CourseEnum;
import Model.Semester;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/courseServ")
public class courseServ extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String depart = request.getParameter("department");
        String sem = request.getParameter("semester");
        String credi = request.getParameter("credit");

        AcademicUnit unit = new AcademicUnit();
        unit.setId(Integer.valueOf(depart));
        Semester sems = new Semester();
        sems.setSem_Id(Integer.valueOf(sem));

        Course cour = new Course();
        cour.setCourse_code(code);
        cour.setName(name);
        cour.setAcademicUnit(unit);
        cour.setSemester_Course(sems);
        cour.setCredit(Integer.parseInt(credi));

        courseDao dao = new courseDao();
        String feed = String.valueOf(dao.registerCourse(cour));
        if (feed!=null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPortal.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }

    }
}
