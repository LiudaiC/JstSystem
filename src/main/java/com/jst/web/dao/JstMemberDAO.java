package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstMember;

import java.util.List;

/**
 * Created by Stefan on 2017/3/6.
 */
public interface JstMemberDAO {

    public long saveMember(JstMember member);
    public JstMember getMemberById(long id);
    public JstMember getMemberByName(String name);
    public List<Long> getMemberIds(int start, int num);
    public int getMemberCount();

}
