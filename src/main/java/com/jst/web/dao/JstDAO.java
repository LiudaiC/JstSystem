package com.jst.web.dao;

import com.jst.web.model.JstMember;
import org.apache.ibatis.annotations.Insert;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by Stefan on 2017/3/6.
 */
@MapperScan
public interface JstDAO {

    @Insert("insert into jst_member(name, phone, registerTime, updateTime)" +
            " values(#{name}, #{phone}, now(), now())")
    public long addMember(JstMember member);
}
