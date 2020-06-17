package com.web.YuYang.Bean;

import lombok.Data;

@Data
public class User_Role {
    private int role_id;
    private int user_id;
    private String role_name;
    private String role_create_time;
    private String role_update_time;
}
