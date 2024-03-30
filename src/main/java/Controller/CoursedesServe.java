package Controller;

import DAO.CourseDefinitionDao;
import Model.Course;
import Model.CourseDefinition;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/CoursedesServe")
public class CoursedesServe extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descri = request.getParameter("description");
        String course = request.getParameter("course");
        Course cour = new Course();
        cour.setCourse_id(Integer.valueOf(course));

        CourseDefinition def = new CourseDefinition();
        def.setCourse(cour);
        def.setDescription(descri);

        CourseDefinitionDao dao = new CourseDefinitionDao();
        String feed = String.valueOf(dao.register(def));
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
