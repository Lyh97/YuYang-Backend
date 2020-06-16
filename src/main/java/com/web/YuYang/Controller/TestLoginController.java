package com.web.YuYang.Controller;

import com.web.YuYang.Bean.Login_Test;
import com.web.YuYang.Service.TestLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TestLoginController {
    @Resource
    TestLoginService service;

    @ResponseBody
    @RequestMapping(value="/selectAll", method=POST)
    public List<Login_Test> selectAllUser(){
        List<Login_Test> users = service.selectAll();
        return users;
    }
}
