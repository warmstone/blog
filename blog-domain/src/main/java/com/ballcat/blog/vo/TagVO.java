package com.ballcat.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-11 15:54
 * @description
 */
@Data
@ApiModel(description = "博客标签显示vo")
public class TagVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("是否删除")
    private Boolean deleted;
}
