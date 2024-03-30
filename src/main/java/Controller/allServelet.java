package Controller;

import DAO.TeacherDao;
import Model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/allServelet")
public class allServelet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String actions = request.getParameter("action");
        if(actions != null && actions.equals("delete"))
        {
            int tec_id = Integer.parseInt(request.getParameter("id"));
             Teacher teacher_del = new Teacher();
             teacher_del.setTeacher_id(tec_id);
             TeacherDao dao = new TeacherDao();
             dao.delete_lecture(teacher_del);

             if(teacher_del !=null)
             {
                 response.sendRedirect("teacherFormall.jsp");
             }
             else
             {
                 response.sendRedirect("AdminPortal.jsp");
             }
        }
        else {}
    }
}
