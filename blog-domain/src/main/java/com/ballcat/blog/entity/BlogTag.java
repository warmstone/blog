package com.ballcat.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-12 10:16
 * @description
 */
@Data
@TableName(value = "t_blog_tag")
public class BlogTag {
    /**
     * 主键
     */
    private Long id;
    /**
     * 博客id
     */
    private Long blogId;
    /**
     * 标签id
     */
    private Long tagId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
