package com.jst.web.dao;

import com.jst.web.model.database.JstMember;

/**
 * Created by Stefan on 2017/3/6.
 */
public interface JstMemberDAO {

    public long saveMember(JstMember member);
    public JstMember getMemberById(long id);

}
