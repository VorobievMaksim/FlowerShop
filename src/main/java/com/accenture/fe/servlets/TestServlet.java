package com.accenture.fe.servlets;

import com.accenture.be.access.UserDAO;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Autowired
    UserDAO userDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
//        resp.setCharacterEncoding("ISO-8859-5");
//        List<User> users = userDAO.getListUsers();
//        PrintWriter writer = resp.getWriter();
//        for (User user : users) {
//            writer.println(user);
//        }
    }
}
