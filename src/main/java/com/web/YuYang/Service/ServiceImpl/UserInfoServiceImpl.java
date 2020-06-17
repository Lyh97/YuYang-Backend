package com.web.YuYang.Service.ServiceImpl;

import com.web.YuYang.Bean.User_Info;
import com.web.YuYang.Mapper.UserInfoMapper;
import com.web.YuYang.Service.UserInfoService;
import com.web.YuYang.Util.CurrentTime;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper mapper;

    CurrentTime current;

    @Override
    public List<User_Info> selectAllUserInfo() {

        List<User_Info> users = mapper.selectAllUserInfo();

        return users;
    }

    @Override
    public Map userLogin(String userName, String userPassword) {

        String passWordMd5 = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        Map<String, Object> loginInfo = new HashMap<>();

        User_Info user = new User_Info();
        user.setUser_name(userName);
        user.setUser_phone(userName);
        user.setUser_password(userPassword);

        User_Info userInfo = mapper.selectUserByUserItem(user);

        if( userInfo == null || userInfo.getUser_name().equals("")) {
            loginInfo.put("loginCode", 401);
            loginInfo.put("loginMessage", "Don't have this User.");
            loginInfo.put("userInfo", "");
        }
        else if(!userInfo.getUser_password().equals(passWordMd5)) {
            loginInfo.put("loginCode", 402);
            loginInfo.put("loginMessage", "Wrong password.");
            loginInfo.put("userInfo", "");
        }
        else {
            loginInfo.put("loginCode", 400);
            loginInfo.put("loginMessage", "LOGIN SUCCESS");
            userInfo.setUser_password("");
            loginInfo.put("userInfo", userInfo);
        }
        return loginInfo;
    }

    @Override
    public Integer addUserInfo(User_Info user) {
        User_Info userResult = mapper.selectUserByUserItem(user);

        if(userResult != null && !userResult.getUser_name().equals("")) {
            return 0;
        }

        CurrentTime current = new CurrentTime();
        String currentTime = current.getCurrentTime("yyyy-MM-dd HH:mm:ss");

        user.setUser_create_time(currentTime);
        user.setUser_update_time(currentTime);

        String passWordMd5 = DigestUtils.md5DigestAsHex(user.getUser_password().getBytes());
        user.setUser_password(passWordMd5);

        mapper.addUserInfo(user);
        return 1;
    }

    @Override
    public void updateUserInfo(User_Info user) {

        CurrentTime current = new CurrentTime();

        user.setUser_update_time(current.getCurrentTime("yyyy-MM-dd HH:mm:ss"));

        String passWordMd5 = DigestUtils.md5DigestAsHex(user.getUser_password().getBytes());
        user.setUser_password(passWordMd5);

        mapper.updateUserInfo(user);
    }

    @Override
    public void deleteUserInfo(int user_id) {
        mapper.deleteUserInfo(user_id);
    }
}