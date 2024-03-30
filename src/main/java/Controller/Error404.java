package Controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Error404")
public class Error404 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Set response content type
        response.setContentType("text/html");

        // Write your custom error page HTML here
        String htmlResponse = "<html><head><title>404 Not Found</title></head><body><h1>404 Not Found</h1><p>The requested resource was not found.Please comeback tommorrow or contact </p></body></html>";

        // Write HTML response to the client
        try {
            response.getWriter().write(htmlResponse);
        } catch (Exception e) {
            // Handle exception if response writing fails
            e.printStackTrace();
        }
    }

}
