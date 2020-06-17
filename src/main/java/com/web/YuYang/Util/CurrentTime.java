package com.web.YuYang.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {

    public String getCurrentTime(String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        String currentTime = df.format(new Date()).toString();

        return currentTime;
    }
}
