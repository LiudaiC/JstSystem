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
public class JstController {

    @Autowired
    private JstMemberManager memManager;

    @RequestMapping("/member/save")
    public long saveMember(@RequestBody RequestMember requestMember) {
        long genId = memManager.saveMember(requestMember);
        return genId;
    }

    @RequestMapping("/member/{id}")
    public JstMember getMember(@PathVariable("id") long id) {
        return memManager.getMember(id);
    }

    @RequestMapping("/product/save")
    public long saveProduct(@RequestBody RequestMember requestMember) {
        long genId = memManager.saveMember(requestMember);
        return genId;
    }

    @RequestMapping("/product/{id}")
    public JstMember getProduct(@PathVariable("id") long id) {
        return memManager.getMember(id);
    }

    @RequestMapping("/login")
    public int login() {
        return 0;
    }

}