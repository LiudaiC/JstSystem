package com.jst.web.action;

import com.jst.web.manager.JstLoginManager;
import com.jst.web.manager.JstMemberManager;
import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstMember;
import com.jst.web.model.request.RequestLogin;
import com.jst.web.model.request.RequestMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody RequestLogin login, HttpServletRequest req, HttpServletResponse res) {
        String sessionId = "";
        Map<String, Object> map = new HashMap<String, Object>();
        int right = 0;
        JstAccount account = loginManager.login(login.getAccount(), login.getPassword());
        int success = 0;
        if (account !=  null) {
            sessionId = UUID.randomUUID().toString();
            req.getSession().setAttribute(sessionId, account);
            map.put("jstSession"+account.getEmpId(), sessionId);
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