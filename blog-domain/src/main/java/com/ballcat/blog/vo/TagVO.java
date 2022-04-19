package com.ballcat.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("是否有效")
    private Boolean enabled;
}
