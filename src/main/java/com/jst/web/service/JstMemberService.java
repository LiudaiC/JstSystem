package com.jst.web.service;

import com.jst.web.dao.JstMemberDAO;
import com.jst.web.model.database.JstMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2017/3/6.
 */
@Service
public class JstMemberService {

    @Autowired
    private JstMemberDAO memberDao;

    public long saveMember(JstMember member) {
        return memberDao.saveMember(member);
    }

    public JstMember getMemberById(long id) {
        return memberDao.getMemberById(id);
    };

    public JstMember getMemberByName(String name) {
        return memberDao.getMemberByName(name);
    }

    public List<Long> getMemberIds(int start, int num) {
        return memberDao.getMemberIds(start, num);
    }

    public int getMemberCount() {
        return memberDao.getMemberCount();
    }
}
