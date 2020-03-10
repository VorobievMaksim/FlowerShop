package com.accenture.fe.servlets;

import com.accenture.be.business.UserBusinessService;
import com.accenture.be.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Autowired
    UserBusinessService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("ISO-8859-5");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            User loginUser = userService.login(username, password);
            req.getSession().setAttribute("user", loginUser);
            resp.sendRedirect("/flowershop/home");
            //resp.getWriter().println(req.getSession().getAttribute("user"));
        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            resp.setStatus(400);
//            resp.getWriter().println(e.getMessage());
            req.setAttribute("error", e.getMessage());
            doGet(req, resp);
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
    }
}
