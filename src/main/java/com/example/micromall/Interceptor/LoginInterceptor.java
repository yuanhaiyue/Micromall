package com.example.micromall.Interceptor;

import com.alibaba.fastjson.JSON;
import com.example.micromall.Vo.UserVo;
import com.example.micromall.utils.JSONResult;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 14760
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserVo user=(UserVo) request.getSession().getAttribute("user");
        if (user==null){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(JSON.toJSON(JSONResult.errorUser("未登录")));
            return false;
        }
        return true;
    }
}
