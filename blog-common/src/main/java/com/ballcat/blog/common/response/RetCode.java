package com.ballcat.blog.common.response;

/**
 * @author pengshun
 * @date 2022-04-06 21:50
 * @description 定义返回状态码
 */
public enum RetCode {

    SUCCESS(200, "成功"),
    FAIL(-1, "失败"),
    NOT_FOUND(404, "访问的资源不存在"),
    UNAUTHORIZED(401, "未认证"),
    PERMISSION_DENIED(403, "权限不足"),
    LOGIN_FAILED(405, "用户名或者密码错误"),
    LOGIN_EXPIRED(406, "登录失效")
    ;

    private Integer code;

    private String message;

    RetCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
