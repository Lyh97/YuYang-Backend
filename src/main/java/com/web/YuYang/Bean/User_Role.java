package com.web.YuYang.Bean;

public class User_Role {
    private int role_id;
    private int user_id;
    private String role_name;
    private String role_create_time;
    private String role_update_time;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_create_time() {
        return role_create_time;
    }

    public void setRole_create_time(String role_create_time) {
        this.role_create_time = role_create_time;
    }

    public String getRole_update_time() {
        return role_update_time;
    }

    public void setRole_update_time(String role_update_time) {
        this.role_update_time = role_update_time;
    }
}
