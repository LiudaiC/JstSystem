package com.jst.web.service;

import com.jst.web.dao.JstChargeDAO;
import com.jst.web.model.database.JstCharge;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stefan on 2017/4/21.
 */
@Service
public class JstChargeService {

    @Autowired
    private JstChargeDAO chargeDAO;

    public void saveCharge(JstCharge charge) {
        chargeDAO.saveCharge(charge);
    }

    public List<JstCharge> getChargeListByMemberId(long memId) {
        return chargeDAO.getChargeListByMemberId(memId);
    }

}
