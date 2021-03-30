package com.example.micromall.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 14760
 */
@Setter
@Getter
public class LogoutResult {

    private Long code;
    private String msg;
    private Long time;
    private Object data;

    public LogoutResult(String msg) {
        this.code=200L;
        this.time=System.currentTimeMillis();
        this.data="";
        this.msg = msg;
    }

    public static LogoutResult logout (String msg){
        return new LogoutResult(msg) ;
    }




}
