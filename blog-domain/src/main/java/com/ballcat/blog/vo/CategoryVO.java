package com.ballcat.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pengshun
 * @date 2022-04-07 22:16
 * @description
 */
@Data
@ApiModel(description = "博客分类显示vo")
public class CategoryVO implements Serializable {

    private static final long serialVersionUID = -840001752066224632L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("分类名称")
    private String categoryName;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("是有有效∂")
    private Boolean enabled;
}
