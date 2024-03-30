package Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter("/filterServelet")
public class filterServelet extends HttpFilter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession ss = httpRequest.getSession(false);
        boolean LoggedIn = (ss != null && ss.getAttribute("email") != null);

        if (LoggedIn){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {

            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.html");
        }
    }

    @Override
    public void destroy() {

    }
}

