package com.ballcat.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pengshun
 * @date 2022-04-11 15:54
 * @description
 */
@Data
@ApiModel(description = "博客标签显示vo")
public class TagVO implements Serializable {

    private static final long serialVersionUID = -5650039102856484278L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("是否有效")
    private Boolean enabled;
}
