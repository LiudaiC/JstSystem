package com.jst.web.dao;

import com.jst.web.model.database.JstEmployee;
import com.jst.web.model.database.JstMember;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Stefan on 2017/3/6.
 */
public interface JstMemberDAO {

    public long saveMember(JstMember member);
    public long updateMember(JstMember member);
    public JstMember getMemberById(long id);
    public JstMember getMemberByCardNo(@Param("cardNo") String cardNo);
    public List<Long> getMemberIdsByName(@Param("name") String name);
    public List<Long> getMemberIds(Map map);
    public int getMemberCount();
    public int expense(Map map);
    public int revokeMember(long id);

}
