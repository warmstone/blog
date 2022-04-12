package com.ballcat.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-11 21:51
 * @description 博客表
 */
@Data
@TableName(value = "t_blog", resultMap = "baseResultMap")
public class Blog {
    /**
     * 主键
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 主图
     */
    private String mainPic;
    /**
     * 分类ID
     */
    private Long categoryId;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否置顶
     */
    @TableField("is_top")
    private Boolean top;
    /**
     * 是否推荐
     */
    @TableField("is_recommended")
    private Boolean recommended;
    /**
     * 是否原创
     */
    @TableField("is_original")
    private Boolean original;
    /**
     * 是否开启评论功能
     */
    @TableField("is_can_commented")
    private Boolean canCommented;
    /**
     * 博客状态，1-保存，2-发布，3-撤回
     */
    private Integer state;
    /**
     * 点赞数
     */
    private Integer likedNum;
    /**
     * 浏览量
     */
    private Integer views;
    /**
     * 评论数
     */
    private Integer commentNum;
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
