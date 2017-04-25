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

/**
 * Created by Administrator on 2017/3/10.
 */
@RestController
@RequestMapping("/jst")
public class JstMemberController {
    @Autowired
    private JstMemberManager memManager;

    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public long saveMember(@RequestBody RequestMember requestMember, HttpServletRequest req, HttpServletResponse res) {
        JstAccount account = JstInterceptor.authenticate(req,res);
        long genId = memManager.saveMember(account.getEmpId(), requestMember);
        return genId;
    }

    @RequestMapping("/members/all")
    public Map<String, Object> getMembers() {
        return memManager.getMembers(1, 1000);
    }

    @RequestMapping("/members/{id}")
    public JstMember getMember(@PathVariable("id") long id) {
        return memManager.getMember(id);
    }

    @RequestMapping("/members/query/{name}")
    public List<JstMember> getMember(@PathVariable("name") String name){
        return memManager.getMemberByName(name);
    }

    @RequestMapping("/members/{page}/{num}")
    public Map<String, Object> getMembers(@PathVariable("page") int page, @PathVariable("num") int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = memManager.getMembers(page, num);
        return map;
    }

    @RequestMapping(value = "/members/info/{memId}", method = RequestMethod.GET)
    public Map<String, Object> getMemberInfo (@PathVariable("memId") long memId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = memManager.getMemberInfo(memId);
        return map;
    }

    @RequestMapping(value = "/members/revoke", method = RequestMethod.POST)
    public int revokeMember(@RequestBody CommonRequest request) {
        return memManager.revokeMember(request.getId());
    }
}
