package com.ballcat.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-12 15:10
 * @description 浏览记录表
 */
@Data
@TableName(value = "t_view_record", resultMap = "baseResultMap")
public class ViewRecord {
    /**
     * id
     */
    private Long id;
    /**
     * 博客id
     */
    private Long blogId;
    /**
     * 博客标题
     */
    private String blogTitle;
    /**
     * ip
     */
    private String viewIp;
    /**
     * 浏览时长
     */
    private Integer viewDuration;
    /**
     * 浏览时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
