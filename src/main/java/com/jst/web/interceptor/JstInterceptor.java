package com.jst.web.interceptor;

import com.jst.web.constant.Constant;
import com.jst.web.model.database.JstAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/11.
 */
@Component
public class JstInterceptor implements HandlerInterceptor{
    private static Logger log = LoggerFactory.getLogger(JstInterceptor.class);
    private static JstAccount account;

    public static JstAccount getAccount() {
        return account;
    }

    public static JstAccount authenticate(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        JstAccount account = new JstAccount();
        Cookie[] cookies = req.getCookies();
        String cookieName = null;
        if (cookies == null) {
            return account;
        }
        for (Cookie cookie : cookies) {
            cookieName = cookie.getName();
            if (Constant.JSTSESSIONID.equals(cookieName)) {
                account = (JstAccount) session.getAttribute(cookie.getValue());
                break;
            }
        }
        if (account != null && account.getId() <= 0) {
            log.error("Account is illegal {}", System.currentTimeMillis());
        }
        return account;
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        JstAccount account = authenticate(req,res);
        if (account == null || account.getId() <= 0) {
            res.sendRedirect("/jst/index?relogin=relogin");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
