package Controller;

import DAO.StudentDao;
import Model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/studentReg")
public class studentReg extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("names");
        String dob = request.getParameter("dob");

        Date dateOfBirth = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBirth = (Date) dateFormat.parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student stud = new Student();
        stud.setName(name);
        stud.setDateOfBirth(dateOfBirth);
        stud.setRegNo(id);
        StudentDao dao = new StudentDao();
        String result = String.valueOf(dao.register(stud));
        if (result !=null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPortal.jsp");
            dispatcher.forward(request, response);
        }
        else
        { response.sendRedirect(request.getContextPath() + "/Error404");
            return;
        }

    }
}
