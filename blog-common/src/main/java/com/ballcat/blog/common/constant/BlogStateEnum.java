package com.ballcat.blog.common.constant;

/**
 * @author pengshun
 * @date 2022-04-12 10:47
 * @description 博客状态
 */
public enum BlogStateEnum {
    /**
     * 待发布
     */
    TO_BE_PUBLISHED(1, "待发布"),
    /**
     * 已发布
     */
    PUBLISHED(2, "已发布"),
    /**
     * 撤回
     */
    WITHDRAW(3, "撤回")
    ;

    private Integer code;

    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    BlogStateEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    BlogStateEnum() {
    }
}
