package com.jst.web.interceptor;

import com.jst.web.model.database.JstAccount;
import com.jst.web.security.SecurityUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/11.
 */
@Component
public class JstInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        JstAccount account = SecurityUtil.authenticate(req,res);
        if (account == null || account.getId() <= 0) {
            res.sendRedirect("/index");
            return false;
        }
        SecurityUtil.setAccount(account);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
