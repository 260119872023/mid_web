package Controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Error500")
public class Error500 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        String htmlResponse = "<html><head><title>500 Internal Server Error</title></head><body><h1>we had a problem please stay on the liner</h1><p>An unexpected error occurred on the server.</p></body></html>";


        try {
            response.getWriter().write(htmlResponse);
        } catch (Exception e) {
            // Handle exception if response writing fails
            e.printStackTrace();
        }
    }


}
