package com.web.YuYang.Service;

import com.web.YuYang.Bean.User_Info;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserInfoService {
    List<User_Info> selectAllUserInfo();

    User_Info selectUserByUserItem(String userName, String userPassword);

    void addUserInfo(User_Info user);

    void updateUserInfo(User_Info user);

    void deleteUserInfo(int parseInt);
}
