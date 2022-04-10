package com.ballcat.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-07 22:16
 * @description
 */
@Data
@ApiModel(description = "博客分类显示vo")
public class BlogCategoryVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("是否删除")
    private Boolean deleted;
}
