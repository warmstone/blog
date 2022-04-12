package com.ballcat.blog.dto;

import com.ballcat.blog.common.validate.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author pengshun
 * @date 2022-04-11 22:22
 * @description
 */
@Data
@ApiModel(description = "保存/修改博客入参")
public class BlogDTO {

    @ApiModelProperty("id")
    @NotNull(message = "id不能为空", groups = Update.class)
    private Long id;

    @ApiModelProperty("标题")
    @NotEmpty(message = "标题不能为空")
    private String title;

    @ApiModelProperty("主图")
    private String mainPic;

    @ApiModelProperty("正文")
    @NotEmpty(message = "正文不能为空")
    private String content;

    @ApiModelProperty("分类")
    @NotNull(message = "标题不能为空")
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

    @ApiModelProperty("博客状态，1-保存，2-发布")
    private Integer state;
}
