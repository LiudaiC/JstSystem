package com.jst.web.manager;

import com.jst.web.model.database.JstMember;
import com.jst.web.model.request.RequestMember;
import com.jst.web.service.JstMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stefan on 2017/3/6.
 */
@Component
public class JstMemberManager {

    @Autowired
    private JstMemberService memberService;

    public long saveMember(RequestMember mem) {
        JstMember member = new JstMember();
        member.setName(mem.getName());
        member.setPhone(mem.getPhone());
        member.setPassword(mem.getPassword());
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        member.setRegisterTime(stamp);
        member.setUpdateTime(stamp);
        memberService.saveMember(member);
        return member.getId();
    }

    public JstMember getMember(long id) {
        return memberService.getMemberById(id);
    }

    public JstMember getMemberByName(String name) {
        return memberService.getMemberByName(name);
    }

    public Map<String, Object> getMembers(int page, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", memberService.getMemberCount());
        int start = (page - 1)*num;
        List<Long> ids = memberService.getMemberIds(start, num);
        final List<JstMember> products = new ArrayList<JstMember>();
        for (long id : ids) {
            products.add(memberService.getMemberById(id));
        }
        map.put("list", products);
        map.put("page", start);
        return map;
    }

}
