package com.web.YuYang.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "User_Info")
@Data
public class User_Info {
    @ApiModelProperty(value = "user_id", name = "用户ID", required = true, example = "")
    private int user_id;
    @ApiModelProperty(value = "user_name", name = "用户名", required = true, example = "Hunter")
    private String user_name;
    @ApiModelProperty(value = "user_password", name = "用户密码", required = true, example = "1234567")
    private String user_password;
    private String user_address;
    private String user_email;
    private String user_age;
    private String user_logo;
    private String user_profile;
    private String user_create_time;
    private String user_update_time;
    private String user_phone;
}