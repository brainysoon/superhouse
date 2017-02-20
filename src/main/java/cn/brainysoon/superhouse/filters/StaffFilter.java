package cn.brainysoon.superhouse.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by brainy on 17-2-20.
 */
@WebFilter(urlPatterns = {"/*"})
public class StaffFilter implements Filter {

    public static String[] URI_SAFE = new String[]{
            "/login",
            "/index"
    };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        Object session = httpServletRequest.getSession().getAttribute("staff");


        String uri = httpServletRequest.getRequestURI();

        //防止拦截器拦截静态资源
        if (uri.contains(".")) {

            chain.doFilter(request, response);
            return;
        }


        for (String s : URI_SAFE) {

            if (s.equals(uri)) {

                chain.doFilter(request, response);
                return;
            }
        }

        if (session == null) {

            httpServletResponse.sendRedirect("/login");
        } else {

            chain.doFilter(request, response);
            return;
        }
    }
}
