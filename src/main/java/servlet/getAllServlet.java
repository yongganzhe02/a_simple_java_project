package servlet;

import bean.Paging;
import bean.User;
import service.UserService;
import service.imp.UserServiceImp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class getAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //调用业务逻辑
        UserService us = new UserServiceImp();
        Paging p=new Paging(us.getAllUserNum(),3);
        p.doPaging(1);

        List<User> users =us.getAllUser(p.getPageNum(),p.getPageSize());
        request.setAttribute("users", users);
        session.setAttribute("p", p);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
