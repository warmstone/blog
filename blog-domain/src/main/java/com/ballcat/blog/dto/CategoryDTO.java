package com.ballcat.blog.dto;

import com.ballcat.blog.common.validate.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author pengshun
 * @date 2022-04-07 22:11
 * @description
 */
@Data
@ApiModel(description = "增加和修改博客分类的入参")
public class CategoryDTO {

    @NotNull(groups = Update.class, message = "id不能为空")
    @ApiModelProperty(value = "id")
    private Long id;

    @NotEmpty(message = "分类名称不能为空")
    @ApiModelProperty(value = "分类名称", required = true)
    private String categoryName;

}
