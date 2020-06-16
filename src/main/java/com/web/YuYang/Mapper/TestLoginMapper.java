package com.web.YuYang.Mapper;

import com.web.YuYang.Bean.Login_Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestLoginMapper {
    List<Login_Test> selectAll();
}
