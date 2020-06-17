package com.web.YuYang.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonResult {

    public JSON generateJsonResult(int code, String message, Object data) {
        JSONObject result = new JSONObject();

        result.put("code", code);
        result.put("messsage", message);
        result.put("data", data);

        return result;
    }

    public JSON generateJsonResult(int code, String message) {
        JSONObject result = new JSONObject();

        result.put("code", code);
        result.put("messsage", message);

        return result;
    }
}
