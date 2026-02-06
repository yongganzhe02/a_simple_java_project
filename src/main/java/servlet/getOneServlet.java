package servlet;

import bean.User;
import service.UserService;
import service.imp.UserServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(name = "getOneServlet",urlPatterns= {"/getOneServlet"})
public class getOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str = request.getParameter("ID");

        //调用业务逻辑
        UserService us = new UserServiceImp();
        User user =us.getUser(str);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/change.jsp").forward(request, response);
    }
}
