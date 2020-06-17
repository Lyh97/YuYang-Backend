package com.web.YuYang.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.YuYang.Bean.User_Info;
import com.web.YuYang.Service.UserInfoService;
import com.web.YuYang.Util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(tags = "用户管理")
@RestController
public class UserInfoController {
    @Resource
    UserInfoService service;

    @RequestMapping(value = "/selectAllUserInfo", method = POST)
    @ApiOperation("查询所有的用户信息")
    public JSON selectAllUserInfo() {
        JsonResult result = new JsonResult();

        List<User_Info> userList = service.selectAllUserInfo();

        return result.generateJsonResult(200, "SUCCESS", userList);
    }

    @RequestMapping(value = "/userLogin", method = POST)
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true),
            @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true)
    })
    public JSON userLogin(@RequestParam String userName, @RequestParam String userPassword) {
        JsonResult result = new JsonResult();

        Map<String, Object> loginInfo = service.userLogin(userName, userPassword);

        int loginCode = (int) loginInfo.get("loginCode");
        String loginMessage = loginInfo.get("loginMessage").toString();
        Object userInfo = loginInfo.get("userInfo");

        return result.generateJsonResult(loginCode, loginMessage, userInfo);
    }

    @RequestMapping(value="/addUserInfo", method = POST)
    @ApiOperation("创建用户")
    public JSON addUserInfo(@RequestBody User_Info userInfo) {

        JsonResult result = new JsonResult();
        Integer insertStatus = 0;

        try {
            insertStatus = service.addUserInfo(userInfo);
        } catch (Exception e) {
            return result.generateJsonResult(301, e.getMessage());
        }

        if(insertStatus == 0 ) {
            return result.generateJsonResult(403, "ADD FAIL, the user's name or phone already exists");
        } else {
            return result.generateJsonResult(200, "ADD SUCCESS");
        }
    }

    @RequestMapping(value="/updateUserInfo", method = POST)
    @ApiOperation("修改用户信息")
    public JSON updateUserInfo(@RequestBody User_Info userInfo) {

        JsonResult result = new JsonResult();

        try {
            service.updateUserInfo(userInfo);
        } catch(Exception e) {
            return result.generateJsonResult(301, e.getMessage());
        }
        return result.generateJsonResult(200, "UPDATE SUCCESS");
    }

    @RequestMapping(value="/deleteUserInfo", method = GET)
    @ApiImplicitParam(name = "user_id", value = "用户ID", required = true)
    public JSON deleteUserInfo(@RequestParam Integer user_id) {

        JsonResult result = new JsonResult();

        try {
            service.deleteUserInfo(user_id);
        } catch(Exception e) {
            return result.generateJsonResult(301, e.getMessage());
        }
        return result.generateJsonResult(200, "DELETE SUCCESS");
    }
}
