package Controller;

import DAO.userdao;
import Model.user;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/loginuserServe")
public class loginuserServe extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String role = request.getParameter("role");

        user user=new user();
        user.setRole(role);
        user.setPassword(pass);
        user.setEmail(email);

        HttpSession ses = request.getSession(true);

        if ("lecture".equals(role)){
            userdao user_dao = new userdao();
            List<user> userList = user_dao.login_user(user);
            if(userList != null)
            {
                ses.setAttribute("email", email);
                ses.setAttribute("role", role);

//                System.out.println(email);

                Cookie cookie_email = new Cookie("email", email);
                Cookie cookie_role = new Cookie("role", role);
                cookie_email.setMaxAge( 50 * 50 * 24);
                cookie_role.setMaxAge(50 * 50 * 24);
                response.addCookie(cookie_role);
                response.addCookie(cookie_email);

                response.sendRedirect("lecturePage.html");
            }
            else{
                RequestDispatcher req_dispatcher = request.getRequestDispatcher("Login.html");
                req_dispatcher.forward(request,response);
            }
        } else if ("student".equals(role)) {
            userdao user_dao = new userdao();
            List<user> userList = user_dao.login_user(user);
            if (userList != null) {
                ses.setAttribute("email", email);
                ses.setAttribute("role", role);

                Cookie cookie_email = new Cookie("email", email);
                Cookie cookie_role = new Cookie("role", role);
                cookie_email.setMaxAge(50 * 50 * 24);
                cookie_role.setMaxAge(50 * 50 * 24);
                response.addCookie(cookie_role);
                response.addCookie(cookie_email);

                response.sendRedirect("indexsss.html");

            } else {
                RequestDispatcher req_dispatcher = request.getRequestDispatcher("Login.html");
                req_dispatcher.forward(request,response);
            }
        }else if("admin".equals(role))
        {
            userdao user_dao = new userdao();
            List<user> userList = user_dao.login_user(user);
            if(userList != null)
            {
                ses.setAttribute("email", email);
                ses.setAttribute("role", role);

                Cookie cookie_email = new Cookie("email", email);
                Cookie cookie_role = new Cookie("role", role);
                cookie_email.setMaxAge( 50 * 50 * 24);
                cookie_role.setMaxAge(50 * 50 * 24);
                response.addCookie(cookie_role);
                response.addCookie(cookie_email);

                response.sendRedirect("AdminPortal.jsp");

            }
            else{
                RequestDispatcher req_dispatcher = request.getRequestDispatcher("Login.html");
                req_dispatcher.forward(request,response);
            }
        }else{
            RequestDispatcher req_dispatcher = request.getRequestDispatcher("Login.html");
            req_dispatcher.forward(request,response);
        }
    }
}
