package com.jst.web.manager;

import com.jst.web.model.database.JstCharge;
import com.jst.web.model.database.JstMember;
import com.jst.web.service.JstChargeService;
import com.jst.web.service.JstMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 2017/4/21.
 */
@Component
public class JstChargeManager {

    @Autowired
    private JstChargeService jstChargeService;
    @Autowired
    private JstMemberService memberService;

    public long saveCharge(JstCharge charge) {
        JstMember member = memberService.getMemberById(charge.getMemberId());
        if (member == null) {
            return -4;
        }
        if (charge.getExtraAmount() == null) {
            charge.setExtraAmount(BigDecimal.ZERO);
        }
        member.setBalanceAmount(member.getBalanceAmount().add(charge.getChargeAmount()).add(charge.getExtraAmount()));
        member.setExtraAmount(member.getExtraAmount().add(charge.getExtraAmount()));
        member.setChargeAmount(member.getChargeAmount().add(charge.getChargeAmount()));
        member.setMemDiscount(charge.getMemDiscount());
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        member.setUpdateTime(updateTime);
        charge.setChargeTime(updateTime);
        jstChargeService.saveCharge(charge);
        memberService.updateMember(member);
        return charge.getId();
    }

    public List<JstCharge> getChargeListByMemberId(long memId) {
        List<JstCharge> list = null;
        list = jstChargeService.getChargeListByMemberId(memId);
        if (list == null) {
            list = new ArrayList<JstCharge>();
        }
        return list;
    }
}
