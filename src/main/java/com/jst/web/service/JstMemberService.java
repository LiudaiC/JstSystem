package com.jst.web.service;

import com.jst.web.dao.JstMemberDAO;
import com.jst.web.model.database.JstMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public long updateMember(JstMember member) {
        return memberDao.updateMember(member);
    }

    public JstMember getMemberById(long id) {
        return memberDao.getMemberById(id);
    };

    public JstMember getMemberByCardNo(String cardNo) {
        return memberDao.getMemberByCardNo(cardNo);
    }

    public List<Long> getMemberIdsByName(String name) {
        return memberDao.getMemberIdsByName(name);
    }

    public List<Long> getMemberIds(int start, int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("num", num);
        return memberDao.getMemberIds(map);
    }

    public int expense(long memberId, BigDecimal expenseAmount) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", memberId);
        map.put("expense", expenseAmount);
        return memberDao.expense(map);
    }

    public int getMemberCount() {
        return memberDao.getMemberCount();
    }

    public int revokeMember(long id) {
        return memberDao.revokeMember(id);
    }

    public JstMember queryMember(String query) {
        return memberDao.queryMember(query);
    }
}
