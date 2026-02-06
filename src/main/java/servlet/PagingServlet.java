package servlet;

import bean.Paging;
import bean.User;
import service.UserService;
import service.imp.UserServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PagingServlet",urlPatterns= {"/PagingServlet"} )
public class PagingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int reqnum = Integer.parseInt(request.getParameter("reqNum"));
        HttpSession session = request.getSession();
        Paging p = (Paging) session.getAttribute("p");
        p.doPaging(reqnum);

        UserService us = new UserServiceImp();
        List<User> users =us.getAllUser(p.getPageNum(),p.getPageSize());
        request.setAttribute("users", users);
        session.setAttribute("p", p);
        //response.sendRedirect("index.jsp");
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
