package com.jst.web.action;

import com.jst.web.constant.Constant;
import com.jst.web.interceptor.JstInterceptor;
import com.jst.web.manager.JstAccountManager;
import com.jst.web.model.database.JstAccount;
import com.jst.web.model.request.RequestLogin;
import com.jst.web.model.request.RequestPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Stefan on 2017/3/1.
 */
@RestController
@RequestMapping("/jst")
public class JstController {

    @Autowired
    private JstAccountManager accountManager;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Map<String, Object> index(HttpServletRequest req, HttpServletResponse res) {
        Map<String, Object> map = new HashMap<String, Object>();
        JstAccount account = JstInterceptor.authenticate(req, res);
        if (account != null && account.getId() > 0) {
            map.put("empId", account.getId());
            map.put("right", account.getAdminRight());
        } else if (req.getQueryString() != null) {
            map.put("relogin", true);
        }
        return map;
    }

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody RequestLogin login, HttpServletRequest req, HttpServletResponse res) {
        String sessionId = "";
        Map<String, Object> map = new HashMap<String, Object>();
        int right = 0;
        JstAccount account = accountManager.login(login.getAccount(), login.getPassword());
        int success = 0;
        if (account !=  null) {
            sessionId = UUID.randomUUID().toString();
            HttpSession session = req.getSession();
            session.setAttribute(sessionId, account);
            session.setMaxInactiveInterval(3600*1000*24);
            map.put(Constant.JSTSESSIONID, sessionId);
            right = account.getAdminRight();
            success = 1;
            map.put("empId", account.getEmpId());
        }
        map.put("success", success);
        map.put("right", right);
        return map;
    }

    @RequestMapping("/logout")
    public int logout(HttpServletRequest req, HttpServletResponse res) {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        HttpSession session = req.getSession();
        for (int i = 0, j = cookies.length; i < j; i++) {
            cookie = cookies[i];
            if (Constant.JSTSESSIONID.equals(cookie.getName())) {
                session.removeAttribute(cookie.getValue());
            }
        }
        return 0;
    }

    @RequestMapping(value = "/passwords", method = RequestMethod.POST)
    public int modifyPassword(@RequestBody RequestPassword req, HttpServletRequest request, HttpServletResponse res) {
        JstAccount account = JstInterceptor.authenticate(request,res);
        if (account!= null && req.getOldPassword() != null
            && !req.getOldPassword().equals(account.getPassword())) {
            return 2;
        }
        return accountManager.modifyPassword(account.getId(), req.getNewPassword());

    }


}