package com.jst.web.manager;

import com.jst.web.model.database.JstMember;
import com.jst.web.model.request.RequestMember;
import com.jst.web.service.JstMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

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

}
