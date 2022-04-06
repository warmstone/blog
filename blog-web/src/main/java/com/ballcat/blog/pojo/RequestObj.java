package com.ballcat.blog.pojo;

import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-06 22:22
 * @description
 */
@Data
public class RequestObj {

    /**
     * 请求URL
     */
    private String url;

    /**
     * 请求类
     */
    private String clazz;

    /**
     * 方法名
     */
    private String method;

    /**
     * 请求参数
     */
    private Object[] args;

    /**
     * 请求IP
     */
    private String ip;
}
