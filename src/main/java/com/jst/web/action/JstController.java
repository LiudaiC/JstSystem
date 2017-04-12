package com.jst.web.action;

import com.jst.web.constant.Constant;
import com.jst.web.manager.JstLoginManager;
import com.jst.web.manager.JstMemberManager;
import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstMember;
import com.jst.web.model.request.RequestLogin;
import com.jst.web.model.request.RequestMember;
import com.jst.web.security.SecurityUtil;
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
    private JstLoginManager loginManager;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Map<String, Object> index(HttpServletRequest req, HttpServletResponse res) {
        Map<String, Object> map = new HashMap<String, Object>();
        JstAccount account = SecurityUtil.authenticate(req, res);
        if (account != null && account.getId() > 0) {
            map.put("right", account.getAdminRight());
        }
        return map;
    }

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody RequestLogin login, HttpServletRequest req, HttpServletResponse res) {
        String sessionId = "";
        Map<String, Object> map = new HashMap<String, Object>();
        int right = 0;
        JstAccount account = loginManager.login(login.getAccount(), login.getPassword());
        int success = 0;
        if (account !=  null) {
            sessionId = UUID.randomUUID().toString();
            HttpSession session = req.getSession();
            session.setAttribute(sessionId, account);
            map.put(Constant.JSTSESSIONID, sessionId);
            right = account.getAdminRight();
            success = 1;
        }
        map.put("success", success);
        map.put("right", right);
        return map;
    }

    @RequestMapping("/logout")
    public int logout(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        session.removeAttribute("jstSession");
        return 0;
    }


}