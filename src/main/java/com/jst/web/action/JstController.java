package com.jst.web.action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stefan on 2017/3/1.
 */
@Controller
public class JstController {

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> helloWorld() {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("1", 1);
        map.put("2",2);
        map.put("3",4);
        return map;
    }

    @RequestMapping("/login")
    @ResponseBody
    public int login() {
        return 0;
    }

}