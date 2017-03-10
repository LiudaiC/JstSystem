package com.jst.web.action;

import com.jst.web.manager.JstMemberManager;
import com.jst.web.model.database.JstMember;
import com.jst.web.model.request.RequestMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Stefan on 2017/3/1.
 */
@RestController
@RequestMapping("/jst")
public class JstController {

    @RequestMapping("/login")
    public int login() {
        return 0;
    }

    @RequestMapping("/logout")
    public int logout() {
        return 0;
    }


}