package com.example.micromall.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;



/**
 * @author 14760
 */
@Getter
@Setter
public class JSONResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    @JsonIgnore
    private String ok;	// 不使用









    public static JSONResult build(Integer status, String msg, Object data) {
        return new JSONResult(status, msg, data);
    }

    public static JSONResult build(Integer status, String msg, Object data, String ok) {
        return new JSONResult(status, msg, data, ok);
    }
    
    public static JSONResult ok(Object data) {
        return new JSONResult(data);
    }
    public static JSONResult ok(Object data,String msg) {
        return new JSONResult(data,msg);
    }
    public static JSONResult ok() {
        return new JSONResult(null);
    }
    
    public static JSONResult errorMsg(String msg) {
        return new JSONResult(400, msg, "");
    }
    
    public static JSONResult errorMap(Object data) {
        return new JSONResult(501, "error", data);
    }
    
    public static JSONResult errorTokenMsg(String msg) {
        return new JSONResult(502, msg, null);
    }
    
    public static JSONResult errorException(String msg) {
        return new JSONResult(555, msg, null);
    }
    
    public static JSONResult errorUser(String msg) {
        return new JSONResult(300, msg, null);
    }

    public JSONResult() {

    }

    public JSONResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public JSONResult(Integer code, String msg, Object data, String ok) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public JSONResult(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }
    public JSONResult(Object data,String msg) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
        this.msg=msg;
    }

    public Boolean isOK() {
        return this.code == 200;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

}
