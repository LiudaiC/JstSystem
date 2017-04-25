package com.jst.web.action;

import com.jst.web.manager.JstChargeManager;
import com.jst.web.model.database.JstCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stefan on 2017/4/21.
 */
@RestController
@RequestMapping("/jst")
public class JstChargeController {

    @Autowired
    private JstChargeManager chargeManager;

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public long saveCharge(@RequestBody JstCharge charge) {
        return chargeManager.saveCharge(charge);
    }

    @RequestMapping(value = "/charge/{memberId}", method = RequestMethod.GET)
    public List<JstCharge> getChargeList(@PathVariable("memberId") long memberId) {
        return chargeManager.getChargeListByMemberId(memberId);
    }

}
