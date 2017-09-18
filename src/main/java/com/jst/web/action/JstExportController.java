package com.jst.web.action;

import com.jst.web.manager.JstExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Stefan on 2017/9/18.
 */
@Controller
public class JstExportController {

    @Autowired
    private JstExportManager exportManager;

    @GetMapping("/jst/export")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        exportManager.export(request, response);
    }

}
