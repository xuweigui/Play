package com.windrift.common.bean;

/**
 * Created by IntelliJ IDEA.
 * User: cy
 * Date: 3/05/12
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Result {
    private ReturnCode returnCode;
    private String msg;

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
