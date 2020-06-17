package com.web.YuYang.Mapper;

import com.web.YuYang.Bean.User_Info;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    public List<User_Info> selectAllUserInfo();

    public User_Info selectUserByUserItem(User_Info user);

    public void addUserInfo(User_Info user);

    public void updateUserInfo(User_Info user);

    public void deleteUserInfo(int user_id);
}
