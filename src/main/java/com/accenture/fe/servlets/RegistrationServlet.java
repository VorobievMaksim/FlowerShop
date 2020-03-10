package com.accenture.fe.servlets;

import com.accenture.be.business.UserBusinessService;
import com.accenture.be.business.UserMarshgallingService;
import com.accenture.be.entity.User;
import com.accenture.fe.dto.RegisterUserDTO;
import jdk.nashorn.internal.objects.annotations.Property;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Autowired
    private UserBusinessService userService;
    @Autowired
    private UserMarshgallingService userMarshgallingService;

    private Properties property = new Properties();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("ISO-8859-5");
        RegisterUserDTO registerUserDTO = new RegisterUserDTO(
                encode(req.getParameter("username")),
                encode(req.getParameter("password")),
                encode(req.getParameter("fullName")),
                encode(req.getParameter("address")),
                encode(req.getParameter("number")));
        FileInputStream stream = new FileInputStream("src/main/resources/application.properties");
        property.load(stream);
        try {
            //User registerUser =
            userMarshgallingService.convertFromObjectToXML(userService.register(registerUserDTO),property.getProperty("user.xml.path"));
            //req.getSession().setAttribute("user", registerUser);
            //resp.getWriter().println(req.getSession().getAttribute("user"));
            resp.sendRedirect("login");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.setStatus(400);
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/registration.jsp").forward(req, resp);
        //resp.getWriter().println(req.getSession().getAttribute("user"));
    }

    private String encode(String str){
        return new String(str.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
    }
}
