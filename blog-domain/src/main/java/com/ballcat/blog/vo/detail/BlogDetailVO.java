package com.ballcat.blog.vo.detail;

import com.ballcat.blog.common.validate.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-11 22:45
 * @description
 */
@Data
@ApiModel(description = "博客详情VO")
public class BlogDetailVO implements Serializable {

    private static final long serialVersionUID = -5956009775515327103L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("主图")
    private String mainPic;

    @ApiModelProperty("正文")
    private String content;

    @ApiModelProperty("分类")
    private Integer categoryId;

    @ApiModelProperty("标签列表")
    private List<Long> tagIds;

    @ApiModelProperty("是否推荐")
    private Boolean recommended;

    @ApiModelProperty("是否开启评论")
    private Boolean canCommented;

    @ApiModelProperty("是否原创")
    private Boolean original;

    @ApiModelProperty("是否开启赞赏功能")
    private Boolean canLiked;
}
