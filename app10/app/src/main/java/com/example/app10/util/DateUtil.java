package com.example.app10.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getNowTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
