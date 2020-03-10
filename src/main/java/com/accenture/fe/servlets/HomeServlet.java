package com.accenture.fe.servlets;

import com.accenture.be.entity.User;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("ISO-8859-5");
        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("username", user.getUsername());
        req.setAttribute("balance", user.getBalance());
        req.setAttribute("discount", user.getDiscount());
    }
}
