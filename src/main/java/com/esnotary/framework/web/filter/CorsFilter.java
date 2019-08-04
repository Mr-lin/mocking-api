package com.esnotary.framework.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author linzhiwei
 * @Description: 去除跨域限制
 * @date 2019/3/5 21:23
 */
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        // Access-Control-Max-Age
        response.setHeader("Access-Control-Max-Age", "3600");
        // Access-Control-Allow-Credentials
        response.setHeader("Access-Control-Allow-Origin", "*");
        // Access-Control-Allow-Methods
        response.setHeader("Access-Control-Allow-Methods", "PUT,POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        if ("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig config) {
    }
}
