package Controller;

import DAO.AcademicDao;
import Model.AcademicUnit;
import Model.CourseEnum;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/academicServelet")
public class academicServelet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String parent = request.getParameter("parent");
        String type = request.getParameter("type");

        Integer parents = null;

        if (parent != null && !parent.isEmpty()) {
            try {
                parents = Integer.parseInt(parent);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        CourseEnum types = CourseEnum.valueOf(type);
        AcademicUnit academic_data = null;

        if (parents != null) {
            academic_data = new AcademicUnit();
            academic_data.setId(parents.intValue());
        }

        AcademicUnit unit = new AcademicUnit();
        unit.setCode(code);
        unit.setName(name);
        unit.setProgram_type(types);
        unit.setAcademicUnit(academic_data);

        AcademicDao dao = new AcademicDao();
        String feedback = String.valueOf(dao.register(unit));
        if(feedback!=null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("test.html");
            dispatcher.forward(request, response);
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);

        }
    }
}
