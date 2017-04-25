package com.jst.web.dao;

import com.jst.web.model.database.JstCharge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Stefan on 2017/4/21.
 */
public interface JstChargeDAO {

    public long saveCharge(JstCharge charge);
    public List<JstCharge> getChargeListByMemberId(@Param("memId") long memId);
}
