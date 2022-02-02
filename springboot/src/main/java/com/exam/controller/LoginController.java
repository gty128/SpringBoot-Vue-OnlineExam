package com.exam.controller;

import com.exam.common.AjaxResult;
import com.exam.entity.*;
import com.exam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody Login login) {

        Object object = loginService.login(login);
        if(object!=null){
            return AjaxResult.success(object);
        }
        return AjaxResult.error( null);
    }
}
