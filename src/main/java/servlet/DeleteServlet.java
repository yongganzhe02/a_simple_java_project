package servlet;

import service.UserService;
import service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet" ,urlPatterns= {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean b=false;
        String str = request.getParameter("ID");

        //调用业务逻辑
        UserService us = new UserServiceImp();
        try {
            b=us.deleteUser(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(b) {
            response.getWriter().write("删除成功!1秒后跳转到主页");
            response.setHeader("refresh", "1;url=" + request.getContextPath() + "/getAllServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
