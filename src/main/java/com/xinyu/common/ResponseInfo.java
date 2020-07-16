package com.xinyu.common;

public class ResponseInfo {
//   code == 1 请求数据成功，else  返回相应的错误码
    private int code = 0;
//    出现错误的时候，给出错误信息
    private String msg = "";
//    返回的数据
    private Object data = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}
