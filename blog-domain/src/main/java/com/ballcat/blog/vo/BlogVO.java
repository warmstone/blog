package com.ballcat.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-11 22:22
 * @description
 */
@Data
@ApiModel(description = "博客列表VO")
public class BlogVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("分类")
    private String categoryName;

    @ApiModelProperty("是否推荐")
    private Boolean recommended;

    @ApiModelProperty("是否开启评论")
    private Boolean canCommented;

    @ApiModelProperty("是否原创")
    private Boolean original;

    @ApiModelProperty("是否置顶")
    private Boolean top;

    @ApiModelProperty("阅读量")
    private Integer viewNum;

    @ApiModelProperty("状态,1-保存,2-发布,3-撤回")
    private Integer state;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
