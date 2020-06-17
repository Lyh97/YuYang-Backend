package com.web.YuYang.Service.ServiceImpl;

import com.web.YuYang.Bean.User_Info;
import com.web.YuYang.Mapper.UserInfoMapper;
import com.web.YuYang.Service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper mapper;

    @Override
    public List<User_Info> selectAllUserInfo() {
        return mapper.selectAllUserInfo();
    }

    @Override
    public User_Info selectUserByUserItem(String userName, String userPassword) {
        return mapper.selectUserByUserItem(userName, userPassword);
    }

    @Override
    public void addUserInfo(User_Info user) {
        mapper.addUserInfo(user);
    }

    @Override
    public void updateUserInfo(User_Info user) {
        mapper.updateUserInfo(user);
    }

    @Override
    public void deleteUserInfo(int user_id) {
        mapper.deleteUserInfo(user_id);
    }
}
