package com.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Demo",
        urlPatterns = { "/LoginServlet" },
        initParams = {
                @WebInitParam(name = "username", value = "Piku"),
                @WebInitParam(name = "password", value = "Darbar")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Getting parameter values from login.html page.
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        // Getting ServletConfig.
        ServletConfig servletConfig = getServletConfig();

        // Getting init config parameter from servletConfig.
        String uname = servletConfig.getInitParameter("username");
        String upwd = servletConfig.getInitParameter("password");

        // Checking user credentials.
        if (uname.equals(user) && upwd.equals(pwd)) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        }
        else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("login.html");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<font color=red>Incorrect username or password login!</font>");
                rd.include(req, resp);
            }
        }
    }
}
