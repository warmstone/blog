package com.ballcat.blog.param;

import com.ballcat.blog.common.response.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pengshun
 * @date 2022-04-11 15:44
 * @description
 */
@Data
@ApiModel(description = "标签查询入参")
public class TagParam extends PageQuery {

    @ApiModelProperty(value = "标签名称", required = false)
    private String tagName;

    @ApiModelProperty(value = "状态是否有效", required = false)
    private Boolean deleted;
}
