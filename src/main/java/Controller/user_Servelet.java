package Controller;

import DAO.userdao;
import Model.user;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/user_Servelet")
public class user_Servelet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String rol = request.getParameter("roles");

        user use = new user();
        use.setEmail(email);
        use.setPassword(pass);
        use.setRole(rol);
        userdao dao = new userdao();
        String result = String.valueOf(dao.register(use));
        if(result!=null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
            dispatcher.forward(request, response);
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("signup.html");
            dispatcher.forward(request, response);
        }
    }
}
