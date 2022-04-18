package com.ballcat.blog.param;

import com.ballcat.blog.common.response.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-07 22:14
 * @description
 */
@Data
@ApiModel(description = "博客分类查询入参")
public class CategoryParam extends PageQuery {

    @ApiModelProperty(value = "分类名称", required = false)
    private String categoryName;

}
