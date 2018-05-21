package com.jst.web.action;

import com.jst.web.interceptor.JstInterceptor;
import com.jst.web.manager.JstMemberManager;
import com.jst.web.model.database.JstAccount;
import com.jst.web.model.database.JstMember;
import com.jst.web.model.request.CommonRequest;
import com.jst.web.model.request.RequestMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jst.web.constant.Constant.PAGE_NUM;

/**
 * Created by Administrator on 2017/3/10.
 */
@RestController
@RequestMapping("/jst")
public class JstMemberController {
    @Autowired
    private JstMemberManager memManager;

    @PostMapping(value = "/members")
    public long saveMember(@RequestBody RequestMember requestMember, HttpServletRequest req, HttpServletResponse res) {
        JstAccount account = JstInterceptor.authenticate(req,res);
        long genId = memManager.saveMember(account.getEmpId(), requestMember);
        return genId;
    }

    @GetMapping(value = "/members/all")
    public Map<String, Object> getAllMembers() {
        return memManager.getMembers(1, Integer.MAX_VALUE);
    }

    @GetMapping(value = "/members")
    public Map<String, Object> getMembers(HttpServletRequest req) {
        int page = Integer.valueOf(req.getParameter("page"));
        return memManager.getMembers(page > 0 ? page : 1, PAGE_NUM);
    }

    @GetMapping("/members/{id}")
    public JstMember getMember(@PathVariable("id") long id) {
        return memManager.getMember(id);
    }

    @GetMapping("/members/query/{name}")
    public List<JstMember> getMember(@PathVariable("name") String name){
        return memManager.getMemberByName(name);
    }

    @GetMapping("/members/{page}/{num}")
    public Map<String, Object> getMembers(@PathVariable("page") int page, @PathVariable("num") int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = memManager.getMembers(page, num);
        return map;
    }

    @GetMapping(value = "/members/info/{memId}")
    public Map<String, Object> getMemberInfo (@PathVariable("memId") long memId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = memManager.getMemberInfo(memId);
        return map;
    }

    @GetMapping(value = "/members/info")
    public JstMember getInfo(HttpServletRequest req) {
        String query = req.getParameter("query");
        JstMember member = memManager.queryMember(query);
        return member;
    }

    @PostMapping(value = "/members/revoke")
    public int revokeMember(@RequestBody CommonRequest request) {
        return memManager.revokeMember(request.getId());
    }
}
