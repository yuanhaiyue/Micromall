package com.example.micromall.utils;

import lombok.Data;

/**
 * @author 14760
 */
@Data
public class NewsResult {

    private Integer status;
    private Object message;


    public NewsResult(Integer status, Object message) {
        this.status = status;
        this.message = message;
    }

    public static NewsResult ok(Object message){
        return new NewsResult(1, message);
    }



}
