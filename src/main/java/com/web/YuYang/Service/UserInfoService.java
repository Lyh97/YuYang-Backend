package com.web.YuYang.Service;

import com.web.YuYang.Bean.User_Info;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    List<User_Info> selectAllUserInfo();

    Integer addUserInfo(User_Info user);

    void updateUserInfo(User_Info user);

    void deleteUserInfo(int parseInt);

    Map userLogin(String userName, String userPassword);
}
