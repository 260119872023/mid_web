package Controller;

import DAO.semesterDao;
import Model.Semester;
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
@WebServlet("/semesterServ")
public class semesterServ extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String start = request.getParameter("start_date");
        String end = request.getParameter("end_date");

        Date date_start= null;
        Date date_end= null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date_start = (Date) dateFormat.parse(start);
            date_end = (Date) dateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Semester semester = new Semester();
        semester.setName(name);
        semester.setStartDate(date_start);
        semester.setEndDate(date_end);

        semesterDao dao = new semesterDao();
        String feed = String.valueOf(dao.register(semester));
        if(feed!=null)
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
