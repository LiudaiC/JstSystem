package com.jst.web.exception;

/**
 * Created by Stefan on 2017/3/6.
 */
public enum JstExceptionValue {

    LOGIN_ERROR(1001, "登录失败，请检查用户名或密码"),
    MEMBER_OPERATION_ERROR(1002, "添加会员错误");

    private int code;
    private String msg;

    private JstExceptionValue(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
