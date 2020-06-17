package com.web.YuYang.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.web.YuYang.Bean.User_Info;
import com.web.YuYang.Service.UserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserInfoController {
    @Resource
    UserInfoService service;

    @RequestMapping(value = "/selectAllUserInfo", method = POST)
    public JSON selectAllUserInfo() {
        JSONObject result = new JSONObject();

        List<User_Info> userList = service.selectAllUserInfo();

        return result;
    }

    @RequestMapping(value = "/userLogin", method = POST)
    public JSON userLogin(@RequestBody String userName, @RequestBody String userPassword) {
        JSONObject result = new JSONObject();

        User_Info userInfo = service.selectUserByUserItem(userName, userPassword);

        return result;
    }

    @RequestMapping(value="/addUserInfo", method = POST)
    public JSON addUserInfo(@RequestBody String params) {
        JSONObject result = new JSONObject();

        User_Info userInfo = JSONObject.parseObject(params, User_Info.class);
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = df.format(new Date()).toString();
            userInfo.setUser_create_time(currentTime);
            userInfo.setUser_update_time(currentTime);

            service.addUserInfo(userInfo);
        } catch (Exception e) {
            result.put("code", 301);
            result.put("messsage", e.getMessage());
        }

        return result;
    }

    @RequestMapping(value="/updateUserInfo", method = POST)
    public JSON updateUserInfo(User_Info user) {
        JSONObject result = new JSONObject();

        try {
            service.updateUserInfo(user);
        } catch(Exception e) {

        }

        return result;
    }

    @RequestMapping(value="/deleteUserInfo", method = POST)
    public JSON deleteUserInfo(@RequestBody String user_id) {
        JSONObject result = new JSONObject();

        try {
            service.deleteUserInfo(Integer.parseInt(user_id));
        } catch(Exception e) {

        }

        return result;
    }
}
