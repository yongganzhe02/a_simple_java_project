package servlet;

import bean.User;

import service.UserService;
import service.imp.UserServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "UpdateServlet" ,urlPatterns= {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean b=false;

        //调用业务逻辑
        User u = new User();
        UserService us = new UserServiceImp();
        u.setId(request.getParameter("id"));
        u.setName(request.getParameter("name"));
        u.setSex(Integer.parseInt(request.getParameter("sex")));


        try {
            b=us.updateUser(u);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(b) {
            response.getWriter().write("修改成功!1秒后跳转到主页");
            response.setHeader("refresh", "1;url=" + request.getContextPath() + "/getAllServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
