package com.jst.web.action;

import com.jst.web.dao.JstMemberDAO;
import com.jst.web.model.JstMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * Created by Stefan on 2017/3/1.
 */
@Controller
@RequestMapping("/jst")
public class JstController {

    @Autowired
    private JstMemberDAO memberDao;

    @RequestMapping("/member/save")
    @ResponseBody
    public long helloWorld() {
        JstMember member = new JstMember();
        member.setName("test");
        member.setPassword("123");
        member.setPhone("13512345678");
        long currTime = System.currentTimeMillis();
        Timestamp stamp = new Timestamp(currTime);
        member.setRegisterTime(stamp);
        member.setUpdateTime(stamp);
        return memberDao.saveMember(member);
    }

    @RequestMapping("/member/{id}")
    @ResponseBody
    public JstMember getMember(long id) {
        return memberDao.getMemberById(id);
    }

    @RequestMapping("/login")
    @ResponseBody
    public int login() {
        return 0;
    }

}