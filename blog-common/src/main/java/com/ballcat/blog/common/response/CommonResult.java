package com.ballcat.blog.common.response;

import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-06 21:46
 * @description 统一返回对象
 */
@Data
public class CommonResult <T>{

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回提示信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 数据总数，前端分页处理
     */
    private Integer total;

    private CommonResult() {
    }

    private CommonResult(Integer code, String message, T data, Integer total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    /**
     * 成功返回
     * @param data 数据
     * @return 成功结果
     */
    public static <T> CommonResult<T> ok(T data) {
        return ok(data, RetCode.SUCCESS.getMessage());
    }

    /**
     * 成功返回分页数据
     * @param data 数据
     * @return 成功结果
     */
    public static <T> CommonResult<T> ok(T data, Integer total) {
        return ok(RetCode.SUCCESS.getCode(), RetCode.SUCCESS.getMessage(), data, total);
    }

    /**
     * 成功返回数据+提示信息
     * @param data 数据
     * @param message 提示信息
     * @return 成功结果
     */
    public static <T> CommonResult<T> ok(T data, String message) {
        return ok(RetCode.SUCCESS.getCode(), message, data, 0);
    }

    /**
     * 成功返回状态码+数据+提示信息+总数
     * @param code 状态码
     * @param message 提示信息
     * @param data 数据
     * @param total 数据总数
     * @return 成功结果
     */
    public static <T> CommonResult<T> ok(Integer code, String message, T data, Integer total) {
        return new CommonResult<>(code, message, data, total);
    }

    /**
     * 失败返回提示信息
     * @param message 提示信息
     * @return 失败提示
     */
    public static <T> CommonResult<T> fail(String message) {
        return fail(RetCode.FAIL.getCode(), message, null, 0);
    }

    /**
     * 失败返回状态码+提示信息
     * @param code 状态码
     * @param message 提示信息
     * @return 失败结果
     */
    public static <T> CommonResult<T> fail(Integer code, String message) {
        return fail(code, message, null, 0);
    }

    /**
     * 失败返回状态码+数据+提示信息+总数
     * @param code 状态码
     * @param message 提示信息
     * @param data 数据
     * @param total 总数
     * @return 错误返回
     */
    public static <T> CommonResult<T> fail(Integer code, String message, T data, Integer total) {
        return new CommonResult<>(code, message, data, total);
    }
}
