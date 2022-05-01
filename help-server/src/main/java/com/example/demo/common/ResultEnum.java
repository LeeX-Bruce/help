package com.example.demo.common;

/**
 * @author LMH
 * @date 2022/4/15 1:03
 * @description 设置通用返回状态码
 */

public enum ResultEnum {
    SUCCESS(200, "成功"),
    UNKNOWN_ERROR(400, "未知错误"),
    USER_NOT_EXIST(401, "用户不存在"),
    USER_IS_EXISTS(402, "用户已存在"),
    DATA_IS_NULL(403, "数据为空"),
    PASSWORD_IS_WRONG(404, "密码错误"),
    SAVE_FAILED(405, "保存失败"),
    UPDATE_FAILED(406, "更新失败"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}