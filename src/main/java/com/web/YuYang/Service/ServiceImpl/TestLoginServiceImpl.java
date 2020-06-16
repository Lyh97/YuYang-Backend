package com.web.YuYang.Service.ServiceImpl;

import com.web.YuYang.Bean.Login_Test;
import com.web.YuYang.Mapper.TestLoginMapper;
import com.web.YuYang.Service.TestLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestLoginServiceImpl implements TestLoginService {

    @Resource
    private TestLoginMapper mapper;

    @Override
    public List<Login_Test> selectAll() {
        return mapper.selectAll();
    }
}
