package servlet;

import bean.User;
import service.UserService;
import service.imp.UserServiceImp;
import util.CreateUUID;

import javax.servlet.annotation.WebServlet;
import java.io.*;


@WebServlet(name = "AddServlet" ,urlPatterns= {"/AddServlet"})
public class AddServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        boolean b = false;
        UserService us = new UserServiceImp();
        User u = new User();

        u.setId(CreateUUID.newGUID());
        u.setName(request.getParameter("name"));
        u.setSex(Integer.parseInt(request.getParameter("sex")));

        //判断是否重复
        User result = us.getUser(u.getId());

        //如果不等于null则说明用户名重复
        if (result != null) {
            request.setAttribute("msg", "Id生成重复，请再试一次");
            request.getRequestDispatcher("/add.jsp").forward(request, response);
        } else {
            //用户名不重复时，执行添加操作
            try {
                b = us.addUser(u);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (b) {
                response.getWriter().write("添加成功!1秒后跳转到主页");
                response.setHeader("refresh", "1;url=" + request.getContextPath() + "/getAllServlet");
            }
        }

    }



    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost( request, response);
    }
}
