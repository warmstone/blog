package com.ballcat.blog.dto;

import com.ballcat.blog.common.validate.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author pengshun
 * @date 2022-04-11 15:39
 * @description
 */
@Data
@ApiModel(description = "增加/修改标签入参")
public class TagDTO {

    @ApiModelProperty("id")
    @NotNull(message = "id不能为空", groups = Update.class)
    private Long id;

    @ApiModelProperty(value = "标签名称", required = true)
    @NotNull(message = "标签名称不能为空")
    private String tagName;
}
