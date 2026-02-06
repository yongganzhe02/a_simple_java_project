package servlet;

import javax.servlet.*;
import java.io.IOException;

public class FilterEncoding implements Filter {

    String encoding=null;

    public void destroy() {
        encoding=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if(encoding!=null)
        {
            req.setCharacterEncoding(encoding);               //设置request的字符编码
            resp.setContentType("text/html;charset="+encoding); //设置response的字符编码

        }
        chain.doFilter(req, resp);    //传递给下一个过滤器

    }

    public void init(FilterConfig config) throws ServletException {
        encoding=config.getInitParameter("encoding");
    }

}
