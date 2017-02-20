package cn.brainysoon.superhouse.filters;

import cn.brainysoon.superhouse.bean.Staff;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by brainy on 17-2-20.
 */
@WebFilter(urlPatterns = "/staff")
public class ManageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String uri = httpServletRequest.getRequestURI();

        if (uri.contains(".")) {

            chain.doFilter(request, response);

            return;
        }

        try {

            HttpSession session = httpServletRequest.getSession();

            if (session == null) {

                chain.doFilter(request, response);
                return;
            }

            Staff staff = (Staff) session.getAttribute("staff");

            if (staff.getIssuper() > 0) {

                chain.doFilter(request, response);
            } else {

                httpServletResponse.sendRedirect("/index");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            chain.doFilter(request, response);
        }
    }
}
