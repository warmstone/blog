package com.ballcat.blog.dto;

import com.ballcat.blog.common.validate.Update;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author pengshun
 * @date 2022-04-07 22:11
 * @description
 */
@Data
public class BlogCategoryDTO {

    @NotNull(groups = Update.class, message = "id不能为空")
    private Long id;

    @NotEmpty(message = "分类名称不能为空")
    private String categoryName;
}
