package com.toxic.job.vo;

/**
 * @author py
 * @date 2018/8/31 下午5:09.
 * 通用返回vo
 */
public class ResultVo {
    private String code;
    private String msg;
    private Object data;
    private Object obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
