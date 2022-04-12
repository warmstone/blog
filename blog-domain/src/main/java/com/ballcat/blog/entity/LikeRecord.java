package com.ballcat.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-12 15:10
 * @description 点赞记录表
 */
@Data
@TableName(value = "t_like_record", resultMap = "baseResultMap")
public class LikeRecord {
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
    private String likeIp;
    /**
     * 点赞时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
