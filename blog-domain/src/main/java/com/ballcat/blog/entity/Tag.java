package com.ballcat.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-11 15:32
 * @description
 */
@Data
@TableName(value = "t_tag")
public class Tag {

    /**
     * id
     */
    private Long id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 逻辑删除标志
     */
    @TableField(value = "is_deleted")
    private Boolean deleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
