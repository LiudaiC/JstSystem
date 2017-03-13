package com.jst.web.action;

import com.jst.web.manager.JstMemberManager;
import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstMember;
import com.jst.web.model.request.RequestMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
@RestController
@RequestMapping("/jst")
public class JstMemberController {
    @Autowired
    private JstMemberManager memManager;

    @RequestMapping("/member/save")
    public long saveMember(@RequestBody RequestMember requestMember) {
        long genId = memManager.saveMember(requestMember);
        return genId;
    }

    @RequestMapping("/member/{id}")
    public JstMember getMember(@PathVariable("id") long id) {
        return memManager.getMember(id);
    }

    @RequestMapping("/member/{name}")
    public JstMember getMember(@PathVariable("name") String name){
        return memManager.getMemberByName(name);
    }

    @RequestMapping("/members")
    public Map<String, Object> getMembers(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = memManager.getMembers(page, num);
        return map;
    }
}
